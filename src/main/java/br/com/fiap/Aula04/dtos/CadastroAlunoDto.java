package br.com.fiap.Aula04.dtos;

import br.com.fiap.Aula04.models.NivelDeEscolaridade;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record CadastroAlunoDto(
        @NotBlank(message = "Nome é obrigatório!")
        @Size(max = 100)
        String nome,

        @NotBlank(message = "CPF é obrigatório!")
        @Size(max = 11, min = 11, message = "CPF tem que ter 11 números.")
        String cpf,

        @Past(message = "Data de nascimento precisa ser no passado.")
        @NotNull(message = "Data de nascimento é obrigatória!")
        LocalDate dataDeNascimento,

        @NotBlank(message = "Nível de Escolaridade é obrigatória!")
        NivelDeEscolaridade nivelDeEscolaridade,

        @PositiveOrZero(message = "A renda não pode ser negativa.")
        Double renda
) {
}
