package org.crawler.shopping.icon.controller;

import jakarta.annotation.Resource;
import org.crawler.shopping.category.dao.entity.Category;
import org.crawler.shopping.icon.controller.viewbean.IconViewBean;
import org.crawler.shopping.icon.dao.dto.IconDto;
import org.crawler.shopping.icon.service.IconService;
import org.crawler.shopping.utils.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/icon")
@CrossOrigin
public class IconController {
    @Resource
    private IconService iconService;

    public Result findAll() {
        List<IconDto> iconDtos = iconService.getAllIconWithCategories();
        List<IconViewBean> iconViewBeans = new ArrayList<>();
        for (IconDto iconDto : iconDtos) {
            IconViewBean iconViewBean = new IconViewBean();
            iconViewBean.setIconId(iconDto.getIconId());
            iconViewBean.setValue(iconDto.getValue());

            Category temp = new Category();
            temp.setId(iconDto.getCategoryId());
            temp.setName(iconDto.getCategoryName());
            List<Category> categories = new ArrayList<>();
            categories.add(temp);
            iconViewBean.setCategories(categories);

            iconViewBeans.add(iconViewBean);
        }
        return Result.ok().data("items", iconViewBeans);
    }
}
