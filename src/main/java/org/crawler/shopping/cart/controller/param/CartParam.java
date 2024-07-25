package org.crawler.shopping.cart.controller.param;

import lombok.Data;

@Data
public class CartParam {
    private Long userId;
    private Long goodId;
    private String standard;
    private Integer count;
}
