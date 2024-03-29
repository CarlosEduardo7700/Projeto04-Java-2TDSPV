package br.com.fiap.Aula04.dtos;

import br.com.fiap.Aula04.models.NivelDeEscolaridade;

import java.time.LocalDate;

public record CadastroAlunoDto(
        String nome,
        String cpf,
        LocalDate dataDeNascimento,
        NivelDeEscolaridade nivelDeEscolaridade,
        Double renda
) {
}
