package org.crawler.shopping.cart.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.crawler.shopping.cart.dao.entity.Cart;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    @Query("select c from Cart c where c.userId = :userId")
    List<Cart> findByUserIdEquals(@Param("userId") Long userId);

    @Transactional
    @Modifying
    @Query("delete from Cart c where c.id = :id")
    int deleteCartById(Long id);
}
