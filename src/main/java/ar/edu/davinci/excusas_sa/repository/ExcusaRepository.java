package ar.edu.davinci.excusas_sa.repository;

import ar.edu.davinci.excusas_sa.model.excusa.Excusa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExcusaRepository extends JpaRepository<Excusa, Long> {
}
