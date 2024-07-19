package org.crawler.shopping.icon.controller.viewbean;

import lombok.Data;
import org.crawler.shopping.category.dao.entity.Category;

import java.util.List;

@Data
public class IconViewBean {
    private Long iconId;
    private String value;
    private List<Category> categories;
}
