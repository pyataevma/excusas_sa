package ar.edu.davinci.excusas_sa.service;

import ar.edu.davinci.excusas_sa.model.empleado.Empleado;
import ar.edu.davinci.excusas_sa.model.prontuario.Prontuario;
import ar.edu.davinci.excusas_sa.repository.ProntuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProntuarioService {
    private ProntuarioRepository repository;
    public ProntuarioService(ProntuarioRepository repository) {
        this.repository = repository;
    }

    public List<Prontuario> obtenerTodos() {
        return repository.findAll();
    }

    public Prontuario guardar(Prontuario prontuario) {
        return repository.save(prontuario);
    }
}
