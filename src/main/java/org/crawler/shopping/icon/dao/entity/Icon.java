package org.crawler.shopping.icon.dao.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.crawler.shopping.category.dao.entity.Category;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "icon")
public class Icon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String value;

//    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "icon")
//    private List<IconCategory> iconCategories;
    @ManyToMany(cascade = CascadeType.MERGE, mappedBy = "icons")
    private List<Category> categories;
}
