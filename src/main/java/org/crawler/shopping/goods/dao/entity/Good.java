package org.crawler.shopping.goods.dao.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "good")
@EntityListeners(AuditingEntityListener.class)
public class Good {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;
  private String name;
  private String description;
  private Double discount;
  private Integer sales;
  private BigDecimal saleMoney;
  private Long categoryId;
  private String imgs;
  @CreatedDate
  private LocalDateTime createTime;
  @LastModifiedDate
  private LocalDateTime updateTime;
  private Boolean recommend;
  private Boolean isDelete;
  private BigDecimal price;
}
