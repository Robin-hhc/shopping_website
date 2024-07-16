package org.crawler.shopping.goods.model.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.crawler.shopping.goods.model.entity.Good;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface GoodRepository extends JpaRepository<Good, Long> {
  Good findBySalesIsAndCategoryIdEqualsAndRecommendEqualsAndDiscountEquals(Integer sales, Long categoryId, Boolean recommend, Double discount);

  Good findByNameAndDescription(String name, String description);

  @Query("select g from Good g where g.name = ?1 and g.saleMoney = ?2 and g.categoryId = ?3")
  Good findGoodByName(String name, int saleMoney, Long categoryId);

  @Query("select g from Good g where g.sales = :sales and g.discount = :discount and g.recommend = :recommend")
  Good findBySalesAndDiscountAndRecommend(@Param("sales") Integer sales, @Param("discount") Double discount
          , @Param("recommend") Boolean recommend);

  @Query("select g from Good g where g.discount = ?1 and g.sales = ?2 and g.createTime = ?3")
  Good ddddd(Double discount, Integer sales, LocalDateTime createTime);

  @Query(nativeQuery = true, value = "select * from good g where g.category_id = ?1 and g.name = ?2")
  Good findGoodByNativeSQL(Long categoryId, String name);

  @Transactional
  @Modifying
  @Query("update Good g set g.name = ?1 where g.id = ?2")
  int updateNameById(String name, Long id);

  void deleteByNameAndDescription(String name, String description);

  @Transactional
  @Modifying
  @Query("delete from Good g where g.discount = :discount and g.price = :price and g.sales = :sales")
  int deletePriceInfo(Double discount, BigDecimal price, Integer sales);

  @Transactional
  @Modifying
  @Query("delete from Good g where g.createTime < ?1 and g.updateTime < ?2")
  int deleteByTimeInfo(LocalDateTime createTime, LocalDateTime updateTime);

  @Modifying
  @Query(nativeQuery = true, value = "delete * from good g where g.sale_money < ?1 and g.price > ?2")
  void deleteBadGoods(Integer SaleMoney, BigDecimal price);
}
