package com.cassio.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Visor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    @NotNull 
    @NotBlank
    @Length(min = 2, max = 100) 
    private String nome;
   
    private String ativo;
   
    private String chamadas;
    
    private String tempo;

    private String recepcao;
    
    private String atendimento;

    private String estatistica;  

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "visor")
    private List<Espec> espec = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "visor")
    private List<Salas> salas = new ArrayList<>();
    
}



