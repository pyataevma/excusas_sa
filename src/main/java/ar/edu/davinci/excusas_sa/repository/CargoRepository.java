package ar.edu.davinci.excusas_sa.repository;

import ar.edu.davinci.excusas_sa.model.cargo.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo, Long> {
}
