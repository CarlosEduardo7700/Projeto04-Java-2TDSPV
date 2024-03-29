package br.com.fiap.Aula04.dtos;

import br.com.fiap.Aula04.models.Aluno;

import java.time.LocalDateTime;

public record ListagemAlunoDto(
        Long rm,
        String nome,
        String cpf,
        LocalDateTime dataCadastro
) {
    public ListagemAlunoDto(Aluno aluno) {
        this(
                aluno.getRm(),
                aluno.getNome(),
                aluno.getCpf(),
                aluno.getDataDeCadastro()
        );
    }
}
