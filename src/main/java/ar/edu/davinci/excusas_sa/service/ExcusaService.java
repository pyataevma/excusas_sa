package ar.edu.davinci.excusas_sa.service;

import ar.edu.davinci.excusas_sa.model.excusa.Excusa;
import ar.edu.davinci.excusas_sa.model.prontuario.Prontuario;
import ar.edu.davinci.excusas_sa.repository.ExcusaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExcusaService {

    @Autowired
    private ExcusaRepository excusaRepository;

    public ExcusaService(ExcusaRepository excusaRepository) {}

    public List<Excusa> obtenerTodos() {
        return excusaRepository.findAll();
    }

    public Excusa guardar(Excusa excusa) {
        return excusaRepository.save(excusa);
    }
}
