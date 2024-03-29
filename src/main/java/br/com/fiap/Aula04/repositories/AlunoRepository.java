package br.com.fiap.Aula04.repositories;

import br.com.fiap.Aula04.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
