package org.crawler.shopping.cart.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.*;
import org.crawler.shopping.cart.controller.param.CartParam;
import org.crawler.shopping.cart.controller.viewbean.CartViewBean;
import org.crawler.shopping.cart.dao.entity.Cart;
import org.crawler.shopping.cart.service.CartService;
import org.crawler.shopping.goods.dao.entity.Good;
import org.crawler.shopping.goods.service.GoodService;
import org.crawler.shopping.utils.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@CrossOrigin
@RequestMapping("/api/cart")
public class CartController {
    @Resource
    private CartService cartServiceImpl;
    @Resource
    private GoodService goodServiceImpl;

    @GetMapping("/userid/{userId}")
    public Result findCartOfUser(@PathVariable Long userId) {
        List<Cart> carts = cartServiceImpl.findCartByUserId(userId);
        List<CartViewBean> cartViewBeans = new ArrayList<>();
        for (Cart cart : carts) {
            CartViewBean cartViewBean = new CartViewBean();
            BeanUtils.copyProperties(cart, cartViewBean);
            Good good = goodServiceImpl.findGoodById(cart.getGoodId());
            cartViewBean.setImg(good.getImgs());
            cartViewBean.setGoodName(good.getName());
            cartViewBean.setPrice(good.getPrice());
            cartViewBean.setDiscount(good.getDiscount());
            cartViewBeans.add(cartViewBean);
        }
        return Result.ok().data("item", cartViewBeans);
    }

    @PostMapping
    public Result saveCart(@RequestBody CartParam cartParam) {
        Cart cart = cartServiceImpl.saveCart(cartParam);
        return Result.ok().data("item", cart);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        cartServiceImpl.deleteCartById(id);
        return Result.ok();
    }

    private static final String TOPIC_NAME = "user.order.topic";
    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;
    @RequestMapping(value = "/saveCartByKafka", method = RequestMethod.POST)
    @ResponseBody
    public Result saveCartByKafka(@RequestBody CartParam cartParam) {
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(TOPIC_NAME, cartParam);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent message=[" + cartParam.toString() +
                        "] with offset=[" + result.getRecordMetadata() + "]");
            } else {
                System.out.println("Unable to send message=[" +
                        cartParam.toString() + "] due to : " + ex.getMessage());
            }
        });;
        return Result.ok();
    }

    @KafkaListener(topics = {"user.order.topic"},groupId = "mall-gp")
    public Result consumerUserOrderSave(String message, Acknowledgment acknowledgment) throws JsonProcessingException {
        System.out.println("Received Message in group foo: " + message);
        ObjectMapper mapper = new ObjectMapper();
        CartParam cartParam = mapper.readValue(message,CartParam.class);
        acknowledgment.acknowledge();
        return Result.ok().data("item",cartServiceImpl.saveCart(cartParam));
    }
}
