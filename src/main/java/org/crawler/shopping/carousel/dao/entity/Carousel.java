package org.crawler.shopping.carousel.dao.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Carousel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * 对应的商品
     */
    private Long goodId;

    /**
     * 轮播顺序
     */
    private Integer showOrder;

}
