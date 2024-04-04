package br.com.fiap.Aula04.repositories;

import br.com.fiap.Aula04.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
