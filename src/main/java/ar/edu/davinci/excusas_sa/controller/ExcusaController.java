package ar.edu.davinci.excusas_sa.controller;

import ar.edu.davinci.excusas_sa.model.dto.ExcusaCreateDTO;
import ar.edu.davinci.excusas_sa.model.dto.ExcusaDTO;
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
    public List<ExcusaDTO>  getAllExcusas() {
        return excusaService.obtenerTodos();
    }

    @PostMapping
    public ExcusaDTO create(@RequestBody ExcusaCreateDTO excusa) {
        return excusaService.guardar(excusa);
    }
}
