package org.crawler.shopping.goods.controller.para;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class GoodPara {
    private String goodName;
    private String goodPrice;
    private int pageNum;
    private int pageSize;
    private Long categoryId;
}
