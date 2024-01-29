package com.cassio.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cassio.dto.VisorDTO;
import com.cassio.services.VisorService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("/api/visores")
public class VisorController {

    private final VisorService visorService;

    public VisorController(VisorService visorService) {
        this.visorService = visorService;
    }


    @GetMapping
    public @ResponseBody List<VisorDTO> list() {
        return visorService.list();
    }
   

    @GetMapping("/{id}")
    public VisorDTO findById(@PathVariable @NotNull @Positive Long id) {
        return visorService.findById(id);
    }
    

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public VisorDTO create(@RequestBody @Valid @NotNull VisorDTO visor) {  
        return visorService.create(visor);
        
    }   

    @PutMapping("/{id}")
    public VisorDTO update(@PathVariable @NotNull @Positive Long id, 
            @RequestBody @Valid @NotNull VisorDTO visor) {
        return visorService.update(id, visor);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id) {
        visorService.delete(id);
    }
   
}


