package br.com.fiap.Aula04.dtos;

import br.com.fiap.Aula04.models.NivelDeEscolaridade;

import java.time.LocalDate;

public record AtualizarAlunoDto(
        String nome,
        LocalDate dataDeNascimento,
        NivelDeEscolaridade nivelDeEscolaridade,
        Double renda
) {
}
