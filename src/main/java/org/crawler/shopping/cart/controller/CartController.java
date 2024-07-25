package org.crawler.shopping.cart.controller;

import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
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
}
