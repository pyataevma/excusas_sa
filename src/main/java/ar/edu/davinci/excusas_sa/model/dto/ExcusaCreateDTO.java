package ar.edu.davinci.excusas_sa.model.dto;

//import ar.edu.davinci.excusas_sa.model.excusa.TipoExcusa;

public class ExcusaCreateDTO {

    private Long empleadoId;
    private String tipo;
    private String texto;

    protected ExcusaCreateDTO() {}

    public ExcusaCreateDTO(Long empleadoId, String tipo, String texto){
        this.tipo = tipo;
        this.empleadoId = empleadoId;
        this.texto = texto;
    }

    public Long getEmpleadoId() {
        return empleadoId;
    }

    public String getTipo() {
        return tipo;
    }

    public String getTexto() {
        return texto;
    }
}
