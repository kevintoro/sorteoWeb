package com.learn.blacklabel.sorteo.repo;

import com.learn.blacklabel.sorteo.model.Sorteo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SorteoRepository extends JpaRepository<Sorteo, Integer>, JpaSpecificationExecutor<Sorteo> {

}