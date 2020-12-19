package com.learn.blacklabel.sorteo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "numero")
public class Numero implements Serializable {

  private static final long serialVersionUID = 1L;

  @Column(name = "boleta")
  private Integer boleta;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "numero")
  private String numero;

}
