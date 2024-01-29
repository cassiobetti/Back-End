package com.cassio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cassio.model.Espec;


public interface EspecRepository extends JpaRepository<Espec, Long> {
    
}
