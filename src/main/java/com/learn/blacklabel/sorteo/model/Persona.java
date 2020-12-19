package com.learn.blacklabel.sorteo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "persona")
public class Persona implements Serializable {

  private static final long serialVersionUID = 1L;

  @Column(name = "documento")
  private String documento;

  @Column(name = "email")
  private String email;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "nombre")
  private String nombre;

  @Column(name = "sorteo")
  private Integer sorteo;

}
