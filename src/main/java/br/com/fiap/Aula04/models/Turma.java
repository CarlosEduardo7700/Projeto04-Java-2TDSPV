package br.com.fiap.Aula04.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "JV_TURMA")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Turma {

    @Id
    @GeneratedValue
    @Column(name = "cd_turma")
    private Long cd;

    @Column(name = "nm_turma", length = 30, nullable = false)
    private String nome;

    @Column(name = "qt_aula")
    private Integer quantidadeDeAula;

    @Enumerated(EnumType.STRING)
    @Column(name = "ds_periodo", length = 20, nullable = false)
    private PeriodoTurma periodo;

    @OneToMany(mappedBy = "turma", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Aluno> alunos = new ArrayList<>();

    @ManyToMany(mappedBy = "turmas")
    private List<Professor> professores;

    //Método para o cadastro da turma e alunos em cascata
    //Seta a FK na tabela aluno
    public void addAluno(Aluno aluno) {
        aluno.setTurma(this);
        alunos.add(aluno);
    }
}
