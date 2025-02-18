package org.crawler.shopping.icon.dao.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.crawler.shopping.category.dao.entity.Category;

import java.util.Collection;
import java.util.List;

@Entity
@Setter
@Getter
public class IconCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iconCategoryId;
    private Long iconId;
}
