package ar.edu.davinci.excusas_sa.controller;

import ar.edu.davinci.excusas_sa.model.empleado.Empleado;
import ar.edu.davinci.excusas_sa.model.prontuario.Prontuario;
import ar.edu.davinci.excusas_sa.service.EmpleadoService;
import ar.edu.davinci.excusas_sa.service.ProntuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prontuarios")
public class ProntuarioController {

        @Autowired
        private ProntuarioService prontuarioService;

        public ProntuarioController(ProntuarioService prontuarioService) {
            this.prontuarioService = prontuarioService;
        }

        @GetMapping("")
        public List<Prontuario> getAllProntuarios() {
            return prontuarioService.obtenerTodos();
        }

        @PostMapping
        public Prontuario createProntuario(@RequestBody Prontuario prontuario) {
            return prontuarioService.guardar(prontuario);
        }
    }
