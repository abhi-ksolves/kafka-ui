package com.provectus.kafka.ui.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("users")
public class Users {
  @Id
  private int id;

  @Column("email")
  private String email;

  @Column("full_name")
  private String fullName;

  @Column("active")
  private boolean active;

  @Column("role_name")
  private String roleName;

  @Column("company")
  private String company;

  @Column("logo")
  private String logo;
}
