package com.provectus.kafka.ui.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("customers")
public class Customers {
  @Id
  private Long id;

  @Column("slug")
  private String slug;

  @Column("full_name")
  private String fullName;

  @Column("company")
  private String company;

  @Column("location")
  private String location;

  @Column("email")
  private String email;

  @Column("logo")
  private String logo;

  @Column("active")
  private boolean active;

  @Column("created_at")
  private LocalDateTime createdAt;

  @Column("updated_at")
  private LocalDateTime updatedAt;
}
