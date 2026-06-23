package ar.edu.davinci.excusas_sa.service;

import ar.edu.davinci.excusas_sa.model.empleado.Empleado;
import ar.edu.davinci.excusas_sa.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    private final EmpleadoRepository repository;

    public EmpleadoService(EmpleadoRepository repository) {
        this.repository = repository;
    }

    public List<Empleado> obtenerTodos() {
        return repository.findAll();
    }

    public Empleado guardar(Empleado empleado) {
        return repository.save(empleado);
    }
}