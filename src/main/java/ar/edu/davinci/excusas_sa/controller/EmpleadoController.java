package ar.edu.davinci.excusas_sa.controller;

import ar.edu.davinci.excusas_sa.model.dto.EmpleadoDTO;
import ar.edu.davinci.excusas_sa.model.empleado.Empleado;
import ar.edu.davinci.excusas_sa.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    //@Autowired
    private EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping
    public List<EmpleadoDTO> getAllEmpleados() {
        return empleadoService.obtenerTodos();
    }

    @PostMapping
    public EmpleadoDTO createEmpleado(@RequestBody EmpleadoDTO dto) {
        return empleadoService.guardar(dto);
    }
}



//        //Endpoint: http + URL
//        @GetMapping("/")
//        public ResponseEntity<String> saludo(){ //localhost:8080/usuarios/
//            return ResponseEntity.ok("Hola");
//        }
//
//        @GetMapping("/{nombre}")//localhost:8080/usuarios/goku
//        public ResponseEntity<String> saludo(@PathVariable String nombre){
//            return ResponseEntity.ok("Hola " + nombre);
//        }

//        @GetMapping("")//localhost:8080/usuarios?nombre=valor1&apellido=valor2
//        public ResponseEntity<String> buscar(@RequestParam(defaultValue = "") String nombre, @RequestParam(defaultValue = "") String apellido){
//            return ResponseEntity.ok("Hola " + nombre + " " + apellido);
//        }
//
//        @PostMapping("")
//        public ResponseEntity<UsuarioDTO> registrar(@RequestBody UsuarioDTO unUsuarioDTO){
//            try{
//                return ResponseEntity.ok(this.usuarioService.registrar(unUsuarioDTO));
//            }catch(UsuarioRegistradoException ex){
//                return ResponseEntity.badRequest().build();
//            }
//        }


