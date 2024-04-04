package br.com.fiap.Aula04.repositories;

import br.com.fiap.Aula04.models.Carteirinha;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteirinhaRepositry extends JpaRepository<Carteirinha, Long> {
}
