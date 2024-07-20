package org.crawler.shopping;

import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;
import org.crawler.shopping.category.dao.entity.Category;
import org.crawler.shopping.icon.dao.dto.IconDto;
import org.crawler.shopping.icon.dao.entity.Icon;
import org.crawler.shopping.icon.dao.entity.IconCategory;
import org.crawler.shopping.icon.dao.repo.IconCategoryRepository;
import org.crawler.shopping.icon.dao.repo.IconRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class IconTest {
    @Resource
    private IconCategoryRepository iconCategoryRepository;
    @Resource
    IconRepository iconRepository;

//    @Test
//    @Transactional
//    public void testOne2ManyWithoutFetchJoin() {
//        List<IconCategory> iconCategories = iconCategoryRepository.findAll();
//        IconCategory iconCategory = iconCategories.get(0);
//        List<Icon> icons = iconCategory.getIcons();
//        assertThat(icons.size()).isEqualTo(1);
//        assertThat(icons.get(0).getId()).isEqualTo(1);
//        assertThat(icons.get(0).getValue()).isEqualTo("&#xe600;");
//    }

//    @Test
//    void testOne2ManyFetchJoin(){
//       List<IconCategory> iconCategoryList = iconCategoryRepository.fetchCategoryAndIcons();
//       IconCategory iconCategory = iconCategoryList.get(0);
//       List<Icon> icons = iconCategory.getIcons();
//       assertThat(icons.size()).isEqualTo(1);
//       assertThat(icons.get(0).getId()).isEqualTo(1);
//       assertThat(icons.get(0).getValue()).isEqualTo("&#xe600;");
//    }

//    @Test
//    void testNoRelJoin(){
//        List<IconCategory> iconCategoryList = iconCategoryRepository.fetchCategoryAndIcons();
//        for (IconCategory iconCategory : iconCategoryList) {
//            System.out.println(iconCategory.getCategoryId().toString()+" "+iconCategory.getIconId().toString());
//        }
//    }
//
//    @Test
//    void testNoRelJoinDto(){
//        List<IconDto> iconDtos = iconCategoryRepository.getCategoryAndIconsByJoin();
//        for (IconDto iconDto : iconDtos) {
//            System.out.print(iconDto.getIconId().toString()+" ");
//            System.out.print(iconDto.getCategoryId().toString()+" ");
//            System.out.print(iconDto.getCategoryName()+" ");
//            System.out.println(iconDto.getValue());
//        }
//    }

    @Test
    @Transactional
    void testMany2Many2One2Many(){
        List<IconDto> iconDtos = new ArrayList<>();
        List<Icon> icons = iconRepository.findAll();
        for (Icon icon : icons) {
            List<Category> categories = icon.getCategories();
            for (Category c: categories) {
                IconDto iconDto = new IconDto(c.getId(),icon.getId(),icon.getValue(),c.getName());
                iconDtos.add(iconDto);
            }
        }
        System.out.println(iconDtos);
    }
}
