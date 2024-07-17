package org.crawler.shopping.icon.dao.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@Entity
public class IconCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryId", nullable = false)
    private Long categoryId;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "iconCategory")
    private List<Icon> icons;
}
