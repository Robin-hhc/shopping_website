package org.crawler.shopping.icon.dao.repo;

import org.crawler.shopping.icon.dao.dto.IconDto;
import org.crawler.shopping.icon.dao.entity.Icon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IconRepository extends JpaRepository<Icon, Long> {

    @Query("select new org.crawler.shopping.icon.dao.dto.IconDto " +
            "(ic.categoryId, ic.iconId, i.value, c.name) from IconCategory ic " +
            "join Icon i on i.id=ic.iconId " +
            "join Category c on ic.categoryId=c.id")
    List<IconDto> getIconWithCategoryInfo();
}
