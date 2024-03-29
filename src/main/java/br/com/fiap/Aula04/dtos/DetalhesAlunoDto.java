package br.com.fiap.Aula04.dtos;

import br.com.fiap.Aula04.models.Aluno;
import br.com.fiap.Aula04.models.NivelDeEscolaridade;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DetalhesAlunoDto(
        Long rm,
        String nome,
        String cpf,
        LocalDate dataDeNascimento,
        LocalDateTime dataDeCadastro,
        NivelDeEscolaridade nivelDeEscolaridade,
        Double renda,
        Integer idade
) {
    public DetalhesAlunoDto(Aluno aluno) {
        this(
                aluno.getRm(),
                aluno.getNome(),
                aluno.getCpf(),
                aluno.getDataDeNascimento(),
                aluno.getDataDeCadastro(),
                aluno.getNivelDeEscolaridade(),
                aluno.getRenda(),
                LocalDate.now().getYear() - aluno.getDataDeNascimento().getYear()
        );

    }
}
