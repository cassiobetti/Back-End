package com.cassio.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;

public record EspecDTO(
     Long id,

     @NotNull
     @Column(unique = true) 
     String nome) {
     
}
