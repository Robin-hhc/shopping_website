package org.crawler.shopping.carousel.controller.viewbean;

import lombok.Data;

@Data
public class CarouselView {
    public CarouselView(Long goodId, String img) {
        this.goodId = goodId;
        this.img = img;
    }

    private Long goodId;
    private String img;
}
