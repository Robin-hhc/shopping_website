package org.crawler.shopping.icon.dao.repo;

import org.crawler.shopping.icon.dao.entity.IconCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface IconCategoryRepository  extends JpaRepository<IconCategory, Long> {
    @Query("select i from IconCategory i join fetch i.icons ")
    List<IconCategory> fetchCategoryAndIcons();
}
