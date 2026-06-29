package ar.edu.davinci.excusas_sa.controller;

import ar.edu.davinci.excusas_sa.model.dto.ProntuarioCreateDTO;
import ar.edu.davinci.excusas_sa.model.dto.ProntuarioDTO;
import ar.edu.davinci.excusas_sa.model.prontuario.Prontuario;
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
        public List<ProntuarioDTO> getAllProntuarios() {
            return prontuarioService.obtenerTodos();
        }

        @PostMapping
        public ProntuarioDTO createProntuario(@RequestBody ProntuarioCreateDTO prontuario) {
            return prontuarioService.guardar(prontuario);
        }
    }
