package org.crawler.shopping.cart.service;

import jakarta.annotation.Resource;
import org.crawler.shopping.cart.controller.param.CartParam;
import org.crawler.shopping.cart.dao.entity.Cart;
import org.crawler.shopping.cart.dao.repo.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CartService {
    List<Cart> findCartByUserId(Long userId);

    Cart saveCart(CartParam cartParam);

    void deleteCartById(Long userId);
}
