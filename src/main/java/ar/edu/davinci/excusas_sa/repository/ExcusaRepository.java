package ar.edu.davinci.excusas_sa.repository;

import ar.edu.davinci.excusas_sa.model.excusa.Excusa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ExcusaRepository extends JpaRepository<Excusa, Long> {

    List<Excusa> findByEmpleadoLegajo(String legajo);

    List<Excusa> findByAceptada(boolean aceptada);

    @Transactional
    int deleteByFechaBefore(LocalDateTime fecha);
}
