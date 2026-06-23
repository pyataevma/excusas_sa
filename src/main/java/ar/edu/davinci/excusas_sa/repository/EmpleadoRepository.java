package ar.edu.davinci.excusas_sa.repository;
import ar.edu.davinci.excusas_sa.model.empleado.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

}
