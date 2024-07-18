package org.crawler.shopping;

import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.crawler.shopping.icon.dao.entity.Icon;
import org.crawler.shopping.icon.dao.entity.IconCategory;
import org.crawler.shopping.icon.dao.repo.IconCategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@SpringBootTest
public class IconTest {
    @Autowired
    private IconCategoryRepository iconCategoryRepository;

    @Test
    @Transactional
    public void testOne2ManyWithoutFetchJoin() {
        List<IconCategory> iconCategories = iconCategoryRepository.findAll();
        IconCategory iconCategory = iconCategories.get(0);
        List<Icon> icons = iconCategory.getIcons();
        assertThat(icons.size()).isEqualTo(1);
    }
}
