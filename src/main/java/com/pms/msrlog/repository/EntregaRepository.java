package com.pms.msrlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pms.msrlog.DTO.EntregaDTO;
import com.pms.msrlog.model.Entrega;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long>{

	
}
