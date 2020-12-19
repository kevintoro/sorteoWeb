package com.learn.blacklabel.sorteo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "boleta")
public class Boleta implements Serializable {

  private static final long serialVersionUID = 1L;

  @Column(name = "boleta")
  private Integer boleta;

  @Column(name = "fecha")
  private LocalDateTime fecha;

  @Column(name = "ganadora")
  private Integer ganadora;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "persona")
  private Integer persona;

  @Column(name = "sorteo")
  private Integer sorteo;

}
