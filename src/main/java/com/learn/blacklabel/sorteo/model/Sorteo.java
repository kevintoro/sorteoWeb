package com.learn.blacklabel.sorteo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

import java.time.LocalDate;
import java.util.Date;

@Table(name = "sorteo")
@Entity
@Data
public class Sorteo implements Serializable {

  private static final long serialVersionUID = 1L;

  @Column(name = "boletas")
  private Integer boletas;

  @Column(name = "fecha")
  private Date fecha;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "maximo")
  private Integer maximo;

  @Column(name = "nombre")
  private String nombre;

  @Column(name = "numeros")
  private Integer numeros;

}
