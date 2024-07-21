package org.crawler.shopping.icon.dao.repo;

import org.crawler.shopping.icon.dao.dto.IconDto;
import org.crawler.shopping.icon.dao.entity.Icon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IconRepository extends JpaRepository<Icon, Long> {
    @Query("select new org.crawler.shopping.icon.dao.dto.IconDto" +
            "(ic.iconCategoryId, i.id, i.value, c.name) from Icon i " +
            "join IconCategory ic on i.id=ic.iconId " +
            "join Category c on c.id=ic.iconCategoryId")
    List<IconDto> getIconAndCategoryInfo();
}
