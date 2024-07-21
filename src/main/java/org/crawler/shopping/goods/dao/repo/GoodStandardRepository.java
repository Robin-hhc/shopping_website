package org.crawler.shopping.goods.dao.repo;

import org.crawler.shopping.goods.dao.entity.GoodStandard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodStandardRepository extends JpaRepository<GoodStandard, Long> {
    List<GoodStandard> findByGoodId(Long goodId);
}
