package ar.edu.davinci.excusas_sa.controller;

import ar.edu.davinci.excusas_sa.model.dto.ExcusaCreateDTO;
import ar.edu.davinci.excusas_sa.model.dto.ExcusaDTO;
import ar.edu.davinci.excusas_sa.service.ExcusaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @GetMapping("/{legajo}")
    public List<ExcusaDTO> getByLegajo(@PathVariable String legajo) {
        return excusaService.obtenerPorLegajo(legajo);
    }

    @GetMapping("/busqueda")
    public List<ExcusaDTO> buscar(
            @RequestParam String legajo,
            @RequestParam(required = false) LocalDate fechaDesde,
            @RequestParam(required = false) LocalDate fechaHasta) {

        return excusaService.buscar(legajo, fechaDesde, fechaHasta);
    }

    @GetMapping("/rechazadas")
    public List<ExcusaDTO> getRachazadas() {
        return excusaService.obtenerRechazadas();
    }
}
