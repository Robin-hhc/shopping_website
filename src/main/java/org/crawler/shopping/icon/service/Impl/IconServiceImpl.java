package org.crawler.shopping.icon.service.Impl;

import jakarta.annotation.Resource;
import org.crawler.shopping.icon.dao.dto.IconDto;
import org.crawler.shopping.icon.dao.repo.IconRepository;
import org.crawler.shopping.icon.service.IconService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IconServiceImpl implements IconService {
    @Resource
    IconRepository iconRepository;

    @Override
    public List<IconDto> getAllIconWithCategories() {
//        return iconRepository.getIconWithCategoryInfo();
        return null;
    }
}
