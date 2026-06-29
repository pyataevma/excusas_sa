package ar.edu.davinci.excusas_sa.repository;

import ar.edu.davinci.excusas_sa.model.excusa.Excusa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExcusaRepository extends JpaRepository<Excusa, Long> {
    default List<Excusa> findByEmpleadoLegajo(String legajo) {
        return null;
    }

    default List<Excusa> findByAceptada(boolean aceptada) {
        return null;
    }
}
