package com.cassio.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class Salas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //@NotBlank    
    //@Length(min = 5, max = 100)
   // @Column(length = 200, nullable = false,unique = true)
    @NotBlank 
    private String nome;

    @ManyToOne(fetch =  FetchType.LAZY, optional = false)
    @JoinColumn(name = "visor_id", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Visor visor;
    
    
}
