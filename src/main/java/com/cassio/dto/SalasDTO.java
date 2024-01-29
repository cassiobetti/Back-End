package com.cassio.dto;

import jakarta.validation.constraints.NotNull;

public record SalasDTO (
    Long id,

    @NotNull
    String nome) {
    
}

