package br.com.fiap.Aula04.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
