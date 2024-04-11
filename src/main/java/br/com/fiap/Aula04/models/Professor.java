package br.com.fiap.Aula04.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "JV_PROFESSOR")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Professor {

    @Id
    @GeneratedValue
    @Column(name = "cd_professor")
    private Long cd;

    @Column(name = "nm_professor", length = 100, nullable = false)
    private String nome;

    @Column(name = "dt_contratacao", nullable = false)
    private LocalDate dataDeContratacao;

    @Column(name = "vl_salario", precision = 9, scale = 2, nullable = false)
    private BigDecimal salario;

    @ManyToMany
    @JoinTable(name = "JV_TURMA_PROFESSOR",
            joinColumns = @JoinColumn(name = "cd_professor"),
            inverseJoinColumns = @JoinColumn(name = "cd_turma"))
    private List<Turma> turmas;
}
