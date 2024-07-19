package org.crawler.shopping.icon.dao.repo;

import org.crawler.shopping.icon.dao.dto.IconDto;
import org.crawler.shopping.icon.dao.entity.IconCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface IconCategoryRepository  extends JpaRepository<IconCategory, Long> {
    @Query("select i from IconCategory ic join Icon i on ic.iconId=i.id")
    List<IconCategory> fetchCategoryAndIcons();

    @Query("select new org.crawler.shopping.icon.dao.dto.IconDto " +
            "(ic.categoryId, i.id, i.value) from IconCategory ic " +
            "join Icon i on i.id = ic.iconId")
    List<IconDto> getCategoryAndIconsByJoin();
}
