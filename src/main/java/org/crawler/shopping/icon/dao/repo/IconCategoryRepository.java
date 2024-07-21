package org.crawler.shopping.icon.dao.repo;

import org.crawler.shopping.icon.dao.dto.IconDto;
import org.crawler.shopping.icon.dao.entity.IconCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface IconCategoryRepository  extends JpaRepository<IconCategory, Long> {
    @Query("select ic from IconCategory ic join Icon i on i.id=ic.iconId")
    List<IconCategory> fetchCategoryAndIcons();

    @Query("select new org.crawler.shopping.icon.dao.dto.IconDto " +
            "(ic.iconCategoryId, ic.iconId, i.value) from IconCategory ic " +
            "join Icon i on i.id=ic.iconId " +
            "join Category c on c.id=ic.iconCategoryId")
    List<IconDto> getCategoryAndIconsByJoin();
}
