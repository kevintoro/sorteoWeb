package com.learn.blacklabel.sorteo.repo;

import com.learn.blacklabel.sorteo.model.Boleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoletaRepository extends JpaRepository<Boleta, Integer>, JpaSpecificationExecutor<Boleta> {
  @Query("SELECT b FROM Boleta b WHERE b.sorteo=:boletaId")
  public List<Boleta> getBoletaBySorteo(@Param("boletaId") int boletaId);
}