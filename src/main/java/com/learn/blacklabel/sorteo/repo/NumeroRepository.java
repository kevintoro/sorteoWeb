package com.learn.blacklabel.sorteo.repo;

import com.learn.blacklabel.sorteo.model.Numero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NumeroRepository extends JpaRepository<Numero, Integer>, JpaSpecificationExecutor<Numero> {

}