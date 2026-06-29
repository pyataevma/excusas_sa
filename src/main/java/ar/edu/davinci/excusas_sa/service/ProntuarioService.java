package ar.edu.davinci.excusas_sa.service;

import ar.edu.davinci.excusas_sa.mapper.ProntuarioMapper;
import ar.edu.davinci.excusas_sa.model.dto.*;
import ar.edu.davinci.excusas_sa.model.excusa.Excusa;
import ar.edu.davinci.excusas_sa.model.prontuario.Prontuario;
import ar.edu.davinci.excusas_sa.repository.ExcusaRepository;
import ar.edu.davinci.excusas_sa.repository.ProntuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProntuarioService {
    private final ProntuarioRepository prontuarioRepository;
    private final ExcusaRepository excusaRepository;
    private final ProntuarioMapper prontuarioMapper;

    public ProntuarioService(ProntuarioRepository prontuarioRepository,
                             ExcusaRepository excusaRepository,
                             ProntuarioMapper prontuarioMapper) {
        this.excusaRepository = excusaRepository;
        this.prontuarioRepository = prontuarioRepository;
        this.prontuarioMapper = prontuarioMapper;
    }

    public List<ProntuarioDTO> obtenerTodos() {
        return prontuarioRepository.findAll()
                .stream()
                .map(prontuario -> prontuarioMapper.toDTO(prontuario))
                .toList();
    }

    public ProntuarioDTO guardar(ProntuarioCreateDTO dto) {
        Excusa excusa = excusaRepository.findById(dto.getExcusaId())
                .orElseThrow(() -> new RuntimeException("Excusa no encontrada"));
        Prontuario prontuario = new Prontuario(excusa);
        Prontuario guardado = prontuarioRepository.save(prontuario);
        return prontuarioMapper.toDTO(guardado);
    }
}
