package com.cassio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cassio.model.Visor;

@Repository
public interface VisorRepository extends JpaRepository<Visor, Long>{

}
