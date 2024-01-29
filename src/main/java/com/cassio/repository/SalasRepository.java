package com.cassio.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.cassio.model.Salas;

public interface SalasRepository extends JpaRepository<Salas, Long> {
    
}

