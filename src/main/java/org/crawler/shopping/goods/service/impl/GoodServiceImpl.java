package org.crawler.shopping.goods.service.impl;

import jakarta.annotation.Resource;
import org.crawler.shopping.goods.dao.entity.Good;
import org.crawler.shopping.goods.dao.repo.GoodRepository;
import org.crawler.shopping.goods.service.GoodService;

import java.util.List;

public class GoodServiceImpl implements GoodService {
    @Resource
    GoodRepository goodRepository;

    @Override
    public List<Good> findAllGoodSvc() {
        List<Good> goods = goodRepository.findAll();
        return goods;
    }
}
