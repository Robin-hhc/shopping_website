package org.crawler.shopping.goods.service;

import org.crawler.shopping.goods.dao.entity.Good;
import org.crawler.shopping.goods.dao.entity.GoodStandard;
import org.crawler.shopping.utils.Page4Navigator;
import org.springframework.data.domain.Page;

import java.util.List;

public interface GoodService {
    public List<Good> findAllGoodSvc();

    Page4Navigator<Good> getAllGoods(int pageNum, int pageSize, Long categoryId);

    Good findGoodById(Long goodId);

    List<GoodStandard> findGoodStandards(Long goodId);

    List<Good> findGoodInGoodIds(List<Long> goodIdList);
}
