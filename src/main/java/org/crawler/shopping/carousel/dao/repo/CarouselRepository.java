package org.crawler.shopping.carousel.dao.repo;

import org.crawler.shopping.carousel.controller.viewbean.CarouselView;
import org.crawler.shopping.carousel.dao.entity.Carousel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarouselRepository extends CrudRepository<Carousel, Long> {
    @Query("select new org.crawler.shopping.carousel.controller.viewbean.CarouselView" +
            "(g.id, g.imgs) from Carousel c join Good g on c.goodId=g.id")
    List<CarouselView> findCarouselAndImg();
}
