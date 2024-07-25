package org.crawler.shopping.carousel.controller;

import jakarta.annotation.Resource;
import org.crawler.shopping.carousel.service.CarouselService;
import org.crawler.shopping.utils.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/carousel")
public class CarouselController {
    @Resource
    private CarouselService carouselServiceImpl;

    @GetMapping
    public Result findAll() {
        return Result.ok().data("item", carouselServiceImpl.findAllCarouses());
    }
}
