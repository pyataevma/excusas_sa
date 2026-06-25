package ar.edu.davinci.excusas_sa.repository;

import ar.edu.davinci.excusas_sa.model.prontuario.Prontuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProntuarioRepository extends JpaRepository<Prontuario, Long> {
}
