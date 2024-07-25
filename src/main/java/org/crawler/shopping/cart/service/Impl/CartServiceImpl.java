package org.crawler.shopping.cart.service.Impl;

import jakarta.annotation.Resource;
import org.crawler.shopping.cart.controller.param.CartParam;
import org.crawler.shopping.cart.dao.entity.Cart;
import org.crawler.shopping.cart.dao.repo.CartRepository;
import org.crawler.shopping.cart.service.CartService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Resource
    private CartRepository cartRepository;

    @Override
    public List<Cart> findCartByUserId(Long userId) {
        return cartRepository.findByUserIdEquals(userId);
    }

    @Override
    public Cart saveCart(CartParam cartParam) {
        Cart cart = new Cart();
        BeanUtils.copyProperties(cartParam, cart);
        cart.setStandard(cartParam.getStandard());
        cartRepository.save(cart);
        return cart;
    }

    @Override
    public void deleteCartById(Long userId) {
        cartRepository.deleteCartById(userId);
    }
}
