package com.learn.blacklabel.sorteo.repo;

import com.learn.blacklabel.sorteo.model.Boleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BoletaRepository extends JpaRepository<Boleta, Integer>, JpaSpecificationExecutor<Boleta> {

}