package org.crawler.shopping.category.dao.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.crawler.shopping.icon.dao.entity.Icon;
import org.crawler.shopping.icon.dao.entity.IconCategory;

import java.util.List;

@Entity
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
}
