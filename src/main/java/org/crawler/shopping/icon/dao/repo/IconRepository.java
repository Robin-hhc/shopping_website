package org.crawler.shopping.icon.dao.repo;

import org.crawler.shopping.icon.dao.dto.IconDto;
import org.crawler.shopping.icon.dao.entity.Icon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IconRepository extends JpaRepository<Icon, Long> {
//    @Query("select new org.crawler.shopping.icon.dao.dto.IconDto " +
//            "(ic.categoryId, ic.iconId, i.value, c.name) from IconCategory ic " +
//            "join Icon i on i.id=ic.iconId " +
//            "join Category c on ic.categoryId=c.id")
//    List<IconDto> getIconWithCategoryInfo();

//    @Query("select new org.crawler.shopping.icon.dao.dto.IconDto " +
//            "(ic.category.id, ic.icon.id, i.value, ic.category.name) from Icon i " +
//            "join fetch IconCategory ic on ic.icon.id = i.id")
//    List<IconDto> getIconDtoByOne2Many();

    @Query("select i from Icon i join fetch i.categories")
    List<Icon> getIconDtoByMany2Many();
}
