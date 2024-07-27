package org.crawler.shopping.goods.controller;

import jakarta.annotation.Resource;
import org.crawler.shopping.goods.controller.para.GoodPara;
import org.crawler.shopping.goods.dao.entity.Good;
import org.crawler.shopping.goods.service.GoodService;
import org.crawler.shopping.utils.Page4Navigator;
import org.crawler.shopping.utils.Result;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/good")
@CrossOrigin
public class GoodContoller {
  @Resource
  GoodService goodService;

  @GetMapping
  public Result findAllGoods() {
    System.out.println("findAllGoods");
    List<Good> goodList = goodService.findAllGoodSvc();
    return Result.ok().data("items", goodList);
  }

  @GetMapping("/findGoodById")
  public Result searchByIdParameter(@RequestParam Long goodId) {
    System.out.println("searchByIdWithParameter");
    Good good = goodService.findGoodById(goodId);
    return Result.ok().data("item", good);
  }

  @GetMapping("/{goodId}")
  public Result searchByIdVariable(@PathVariable Long goodId) {
    System.out.println("searchByIdWithPathVariable");
    Good good = goodService.findGoodById(goodId);
    return Result.ok().data("item", good);
  }

  @PostMapping("/addGood")
  public Result addGood(@RequestBody @Validated GoodPara para) {
    System.out.println("addGood");
    return Result.ok();
  }

  @PostMapping("/page")
  public Result getAllGoodsWithPageNumAndSize(@RequestBody @Validated GoodPara para) {
    System.out.println("getAllGoodsWithPageNumAndSize");
    Page4Navigator<Good> goodList = goodService.getAllGoods(para.getPageNum(), para.getPageSize(), para.getCategoryId());
    return Result.ok().data("items", goodList);
  }
}
