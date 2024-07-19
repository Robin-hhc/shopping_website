package org.crawler.shopping.icon.dao.dto;

import lombok.Data;

@Data
public class IconDto {
    private Long categoryId;
    private Long iconId;
    private String value;
    private String categoryName;
    public IconDto(Long categoryId, Long iconId, String value) {
        this.categoryId = categoryId;
        this.iconId = iconId;
        this.value = value;
    }

    public IconDto(Long categoryId, Long iconId, String value, String categoryName) {
        this.categoryId = categoryId;
        this.iconId = iconId;
        this.value = value;
        this.categoryName = categoryName;
    }
}
