package com.cassio.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cassio.dto.EspecDTO;
import com.cassio.dto.SalasDTO;
import com.cassio.dto.VisorDTO;
import com.cassio.model.Espec;
import com.cassio.model.Salas;
import com.cassio.model.Visor;

@Component
public class VisorMapper {

    public VisorDTO toDTO(Visor visor) {
        if (visor == null) {
            return null;
            
        }
        List<EspecDTO> especs = visor.getEspec()
                .stream()
                .map(espec -> new EspecDTO(espec.getId(), espec.getNome()))
                .collect(Collectors.toList());
      
        List<SalasDTO> sala = visor.getSalas()
                .stream()
                .map(salas -> new SalasDTO(salas.getId(), salas.getNome()))
                .collect(Collectors.toList());
        return new VisorDTO(visor.getId(), visor.getNome(), visor.getAtivo(), 
        visor.getChamadas(), visor.getTempo(), visor.getRecepcao(), 
        visor.getAtendimento(), visor.getEstatistica(), especs, sala);

    
        
    }
    

        
    public Visor toEntity(VisorDTO visorDTO) {
        
        if (visorDTO == null) {
            return null;
            
        }

        Visor visor = new Visor();
        if (visorDTO.id() != null) {
            visor.setId(visorDTO.id());

        }
        
        visor.setNome(visorDTO.nome());
        visor.setAtivo(visorDTO.ativo());
        visor.setChamadas(visorDTO.chamadas());
        visor.setTempo(visorDTO.tempo());
        visor.setRecepcao(visorDTO.recepcao());
        visor.setAtendimento(visorDTO.atendimento());
        visor.setEstatistica(visorDTO.estatistica());

        List<Espec> especs = visorDTO.espec().stream().map(especDTO -> {
            var espec = new Espec();
            espec.setId(especDTO.id());
            espec.setNome(especDTO.nome());
            espec.setVisor(visor);
            return espec;
        }).collect(Collectors.toList());
        visor.setEspec(especs);
        

        List<Salas> sala = visorDTO.salas().stream().map(SalasDTO -> {
            var salas = new Salas();
            salas.setId(SalasDTO.id());
            salas.setNome(SalasDTO.nome());
            salas.setVisor(visor);
            return salas;
        }).collect(Collectors.toList());
        visor.setSalas(sala);
        return visor;

    }
    
    

}
