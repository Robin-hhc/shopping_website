package org.crawler.shopping.cart.controller.viewbean;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CartViewBean {
    /**
     * Good name
     */
    private String goodName;

    private Long goodId;
    private Long userId;
    private Integer count;
    private Long id;
    private LocalDateTime createTime;
    private String standard;
    private Double discount;

    /**
     * Good pictures
     */
    private String img;

    private BigDecimal price;
}
