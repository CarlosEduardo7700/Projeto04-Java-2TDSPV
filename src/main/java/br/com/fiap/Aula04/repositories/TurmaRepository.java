package br.com.fiap.Aula04.repositories;

import br.com.fiap.Aula04.models.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
}
