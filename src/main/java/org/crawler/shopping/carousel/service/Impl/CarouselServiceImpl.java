package org.crawler.shopping.carousel.service.Impl;

import jakarta.annotation.Resource;
import org.crawler.shopping.carousel.controller.viewbean.CarouselView;
import org.crawler.shopping.carousel.dao.repo.CarouselRepository;
import org.crawler.shopping.carousel.service.CarouselService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarouselServiceImpl implements CarouselService {
    @Resource
    private CarouselRepository carouselRepository;

    @Override
    public List<CarouselView> findAllCarouses() {
        return carouselRepository.findCarouselAndImg();
    }
}
