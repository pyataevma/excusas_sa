package ar.edu.davinci.excusas_sa.factory;

import ar.edu.davinci.excusas_sa.model.empleado.Empleado;
import ar.edu.davinci.excusas_sa.model.excusa.*;
import org.springframework.stereotype.Component;

@Component
public class ExcusaFactory {
    public Excusa crear(
            TipoExcusa tipo,
            Empleado empleado,
            String texto) {

        return switch (tipo) {
            case TRIVIAL ->
                    new ExcusaTrivial(empleado, texto);

            case CORTO_LUZ ->
                    new ExcusaCortoDeLuz(empleado, texto);

            case CUIDAR_FAMILIAR ->
                    new ExcusaCuidarAFamiliar(empleado, texto);

            case COMPLEJA ->
                    new ExcusaCompleja(empleado, texto);

            case INVEROSIMIL ->
                    new ExcusaInverosimil(empleado, texto);
        };
    }
}
