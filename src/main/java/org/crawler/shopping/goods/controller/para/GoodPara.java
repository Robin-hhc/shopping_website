package org.crawler.shopping.goods.controller.para;

import jakarta.validation.constraints.NotBlank;

public class GoodPara {
  @NotBlank(message = "Good name can not be blank.")
  private String goodName;
  private String goodDescription;
  private Long goodPrice;

  @Override
  public String toString() {
    return "Parameter has name as " + goodName + ", price as " + goodPrice.toString() +
            ". Here is the description of the good: " + goodDescription;
  }
}
