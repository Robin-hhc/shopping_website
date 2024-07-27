package org.crawler.shopping.cart.service.Impl;

import jakarta.annotation.Resource;
import org.crawler.shopping.cart.controller.param.CartParam;
import org.crawler.shopping.cart.dao.entity.Cart;
import org.crawler.shopping.cart.dao.repo.CartRepository;
import org.crawler.shopping.cart.service.CartService;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class CartServiceImpl implements CartService {
    @Resource
    private CartRepository cartRepository;

    @Resource
    RedisTemplate redisTemplate;

    @Override
    public List<Cart> findCartByUserId(Long userId) {
        String userIdKey = "cart:" + userId.toString();
        String searchKey = userIdKey + "-*";
        Set<String> keys = redisTemplate.keys(searchKey);
        List<Cart> values = redisTemplate.opsForValue().multiGet(keys);
        List<Cart> cartList = new ArrayList<>();
        if (values.size() > 0) {
            cartList = values;
        } else {
            cartList = cartRepository.findByUserIdEquals(userId);
            for (Cart cart : cartList) {
                String cartIdKey = cart.getId().toString();
                String key = userIdKey + "-" + cartIdKey;
                BoundValueOperations userCart = redisTemplate.boundValueOps(key);
                userCart.set(cart, 3600, TimeUnit.SECONDS);
            }
        }
        return cartList;
    }

    @Override
    @CachePut(value = "Cart", key = "#cartParam.userId + '-' + #result.id",cacheManager = "cacheManager1Hour")
    public Cart saveCart(CartParam cartParam) {
        Cart cart = new Cart();
        BeanUtils.copyProperties(cartParam, cart);
        cart.setStandard(cartParam.getStandard());
        cartRepository.save(cart);
        return cart;
    }

    @Override
    @CacheEvict(value = "Cart",key = "#userId + '-' + #cartId",cacheManager = "cacheManager1Hour")
    public void deleteCartById(Long userId) {
        cartRepository.deleteCartById(userId);
    }
}
