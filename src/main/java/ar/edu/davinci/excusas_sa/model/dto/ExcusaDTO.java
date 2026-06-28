package ar.edu.davinci.excusas_sa.model.dto;

import ar.edu.davinci.excusas_sa.model.excusa.TipoExcusa;

import java.time.LocalDateTime;

public class ExcusaDTO {

        private Long id;
        private EmpleadoDTO empleadoDTO;
        private TipoExcusa tipo;
        private String texto;
        private LocalDateTime fecha;
        private Boolean aceptada;

        protected ExcusaDTO() {}

        public ExcusaDTO(Long id, EmpleadoDTO empleadoDTO, TipoExcusa tipo, String texto, LocalDateTime fecha, Boolean aceptada) {
            this.id = id;
            this.tipo = tipo;
            this.empleadoDTO = empleadoDTO;
            this.texto = texto;
            this.fecha = fecha;
            this.aceptada = aceptada;
        }

    public Long getId() {
        return id;
    }

    public EmpleadoDTO getEmpleadoDTO() {
        return empleadoDTO;
    }

    public TipoExcusa getTipo() {
        return tipo;
    }

    public String getTexto() {
        return texto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public Boolean getAceptada() {
        return aceptada;
    }

}
