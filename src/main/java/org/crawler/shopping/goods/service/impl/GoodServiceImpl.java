package org.crawler.shopping.goods.service.impl;

import jakarta.annotation.Resource;
import org.crawler.shopping.goods.dao.entity.Good;
import org.crawler.shopping.goods.dao.entity.GoodStandard;
import org.crawler.shopping.goods.dao.repo.GoodRepository;
import org.crawler.shopping.goods.dao.repo.GoodStandardRepository;
import org.crawler.shopping.goods.service.GoodService;
import org.crawler.shopping.utils.Page4Navigator;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodServiceImpl implements GoodService {
    @Resource
    GoodRepository goodRepository;
    @Resource
    GoodStandardRepository goodStandardRepository;

    @Override
    @Cacheable(value = "Goods", keyGenerator = "springCacheCustomKeyGenerator", cacheManager = "cacheManager1Hour")
    public List<Good> findAllGoodSvc() {
        return goodRepository.findAll();
    }

    @Override
    @Cacheable(value = "Goods", keyGenerator = "springCacheCustomKeyGenerator", cacheManager = "cacheManager1Hour")
    public Page4Navigator<Good> getAllGoods(int pageNum, int pageSize, Long categoryId) {
        if (pageNum < 1 || pageSize < 1) {
            pageNum = 1;
        }
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        Page tempPage = goodRepository.findAllGoodsOfCategoryWithPageable(pageable,categoryId );
        Page4Navigator<Good> returnPage = new Page4Navigator<>(tempPage,pageNum-1);
        return returnPage;
    }

    @Override
    @Cacheable(value = "Goods", keyGenerator = "springCacheCustomKeyGenerator", cacheManager = "cacheManager1Hour")
    public Good findGoodById(Long goodId) {
        return goodRepository.findById(goodId).get();
    }

    @Override
    public List<GoodStandard> findGoodStandards(Long goodId) {
        return goodStandardRepository.findByGoodId(goodId);
    }

    @Override
    @Cacheable(value = "Goods", keyGenerator = "springCacheCustomKeyGenerator", cacheManager = "cacheManager1Hour")
    public List<Good> findGoodInGoodIds(List<Long> goodIdList) {
        return goodRepository.findAllById(goodIdList);
    }


}
