package org.crawler.shopping.goods.controller;

import org.crawler.shopping.goods.controller.para.GoodPara;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/good")
@CrossOrigin
public class GoodContoller {

  @GetMapping
  public String allGoods() {
    System.out.println("findAllGoods");
    return "findAllGoods";
  }

  @GetMapping("/searchById")
  public Long searchByIdParameter(@RequestParam Long id) {
    System.out.println("searchById");
    return id;
  }

  @GetMapping("/{goodId}")
  public Long searchByIdVariable(@PathVariable Long goodId) {
    System.out.println(goodId);
    return goodId;
  }

  @PostMapping("/addGood")
  public GoodPara addGood(@RequestBody @Validated GoodPara para) {
    System.out.println(para);
    return para;
  }
}
