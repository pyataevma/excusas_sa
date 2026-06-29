package ar.edu.davinci.excusas_sa.repository;

import ar.edu.davinci.excusas_sa.model.empleado.responsable.cargo.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo, Long> {
}
