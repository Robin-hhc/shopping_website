package org.crawler.shopping.carousel.service;

import org.crawler.shopping.carousel.controller.viewbean.CarouselView;

import java.util.List;

public interface CarouselService {
    public List<CarouselView> findAllCarouses();
}
