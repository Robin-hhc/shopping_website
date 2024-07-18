package org.crawler.shopping.icon.dao.dto;

import lombok.Data;

@Data
public class IconDTO {
    private Long categoryId;
    private Long iconId;
    private String value;
    public IconDTO (Long categoryId, Long iconId, String value) {
        this.categoryId = categoryId;
        this.iconId = iconId;
        this.value = value;
    }
}
