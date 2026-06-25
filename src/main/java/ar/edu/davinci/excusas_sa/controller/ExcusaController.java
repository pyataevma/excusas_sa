package ar.edu.davinci.excusas_sa.controller;

import ar.edu.davinci.excusas_sa.model.excusa.Excusa;
import ar.edu.davinci.excusas_sa.repository.EmpleadoRepository;
import ar.edu.davinci.excusas_sa.repository.ExcusaRepository;
import ar.edu.davinci.excusas_sa.service.ExcusaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/excusas")
public class ExcusaController {

    @Autowired
    private ExcusaService excusaService;

    public ExcusaController(ExcusaService excusaService) {
        this.excusaService = excusaService;
    }

    @GetMapping
    public List<Excusa>  getAllExcusas() {
        return excusaService.obtenerTodos();
    }

    @PostMapping
    public Excusa create(@RequestBody Excusa excusa) {
        return excusaService.guardar(excusa);
    }
}
