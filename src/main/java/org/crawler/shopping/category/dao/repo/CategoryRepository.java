package org.crawler.shopping.category.dao.repo;

import org.crawler.shopping.category.dao.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<Category, Long> {
}
