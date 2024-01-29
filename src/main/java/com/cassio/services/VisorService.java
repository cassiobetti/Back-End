package com.cassio.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

import com.cassio.dto.VisorDTO;
import com.cassio.dto.mapper.VisorMapper;
import com.cassio.exception.RecordNotFoundException;
import com.cassio.model.Visor;
import com.cassio.repository.VisorRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class VisorService {

    private final VisorRepository visorRepository;
    private final VisorMapper visorMapper;

    public VisorService(VisorRepository visorRepository, VisorMapper visorMapper) {
        this.visorRepository = visorRepository;
        this.visorMapper = visorMapper;
    }
    
    public List<VisorDTO> list() {
        return visorRepository.findAll()
                .stream()
                .map(visorMapper::toDTO)
                .collect(Collectors.toList());
    }

    

    public VisorDTO findById(@PathVariable @NotNull @Positive Long id) {
        return visorRepository.findById(id).map(visorMapper::toDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }


    public VisorDTO create(@Valid @NotNull VisorDTO visor) {
        return visorMapper.toDTO(visorRepository.save(visorMapper.toEntity(visor)));
    }

    

    public VisorDTO update(@NotNull @Positive Long id, @Valid @NotNull VisorDTO visorDTO) {
        return visorRepository.findById(id)
                .map(recordFound -> {
                    Visor visor = visorMapper.toEntity(visorDTO);
                    recordFound.setNome(visorDTO.nome());
                    recordFound.setAtivo(visorDTO.ativo());
                    recordFound.setChamadas(visorDTO.chamadas());
                    recordFound.setTempo(visorDTO.tempo());
                    recordFound.setRecepcao(visorDTO.recepcao());
                    recordFound.setAtendimento(visorDTO.atendimento());
                    recordFound.setEstatistica(visorDTO.estatistica());
                    recordFound.getEspec().clear();
                    recordFound.getSalas().clear();
                    visor.getEspec().forEach(recordFound.getEspec()::add);
                    visor.getSalas().forEach(recordFound.getSalas()::add);
                    return visorMapper.toDTO(visorRepository.save(recordFound));
                }).orElseThrow(() -> new RecordNotFoundException(id));
    }
    
    public void delete(@PathVariable @NotNull @Positive Long id) {
        visorRepository.delete(visorRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));
    }

}