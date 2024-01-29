package com.cassio.dto;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VisorDTO(
    @JsonProperty("_id") Long id, 
    @NotBlank @NotNull @Length(min = 2, max = 100)String nome, 
    String ativo, 
    String chamadas, 
    String tempo, 
    String recepcao, 
    String atendimento, 
    String estatistica,
    List<EspecDTO> espec,
    List<SalasDTO> salas){
   
    
    
}
