package com.example.fullstacktaskapp.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Task implements Serializable {
  
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long id;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false, insertable = false, updatable = false)
  private Date createdDate;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false, insertable = false, updatable = false)
  private Date lastModifiedDate;

  @Column(nullable = false)
  private String content;

  @Column(nullable = false)
  private Boolean done = false;

  public Task(String content) {
    this.content = content;
  }
}
