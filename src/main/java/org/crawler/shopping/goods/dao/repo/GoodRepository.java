package org.crawler.shopping.goods.dao.repo;


import org.hibernate.annotations.SQLInsert;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.crawler.shopping.goods.dao.entity.Good;

public interface GoodRepository extends JpaRepository<Good, Long> {
    @Query("select m from Good m where m.categoryId = :categoryId")
    Page<Good> findAllGoodsOfCategoryWithPageable(Pageable pageable, Long categoryId);
}
