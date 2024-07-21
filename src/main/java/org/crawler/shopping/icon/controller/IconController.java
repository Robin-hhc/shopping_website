package org.crawler.shopping.icon.controller;

import jakarta.annotation.Resource;
import org.crawler.shopping.category.dao.entity.Category;
import org.crawler.shopping.icon.controller.viewbean.IconViewBean;
import org.crawler.shopping.icon.dao.dto.IconDto;
import org.crawler.shopping.icon.service.IconService;
import org.crawler.shopping.utils.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/icon")
@CrossOrigin
public class IconController {
    @Resource
    private IconService iconService;

    @GetMapping
    public Result findAll() {
        List<IconDto> iconDtos = iconService.getIconCategoriesList();
        List<IconViewBean> iconViewBeans = new ArrayList<>();
        HashMap<String, List<Category>> temMap = new HashMap<>();
        for (IconDto iconDto : iconDtos) {
            IconViewBean iconViewBean = new IconViewBean();
            iconViewBean.setValue(iconDto.getValue());

            Category temp = new Category();
            temp.setId(iconDto.getCategoryId());
            temp.setName(iconDto.getCategoryName());

            if (temMap.containsKey(iconDto.getValue())) {
                temMap.get(iconDto.getValue()).add(temp);
            } else {
                List<Category> tempList = new ArrayList<>();
                tempList.add(temp);
                temMap.put(iconDto.getValue(), tempList);
            }
        }

        for (String key:
             temMap.keySet()) {
            IconViewBean iconViewBean = new IconViewBean();
            iconViewBean.setCategories(temMap.get(key));
            iconViewBean.setValue(key);
            iconViewBeans.add(iconViewBean);
        }
        return Result.ok().data("item", iconViewBeans);
    }
}
