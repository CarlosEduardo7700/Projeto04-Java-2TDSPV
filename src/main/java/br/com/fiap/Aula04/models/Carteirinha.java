package br.com.fiap.Aula04.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "JV_CARTEIRINHA")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Carteirinha {

    @Id
    @GeneratedValue
    @Column(name = "cd_carteirinha")
    private Long cd;

    @Column(name = "dt_emissao", nullable = false)
    private LocalDate dataDeEmissão;

    @Column(name = "dt_vencimento")
    private LocalDate dataDeVencimento;

    @Column(name = "st_ativo", nullable = false)
    private Boolean statusAtivo;

    @OneToOne
    @JoinColumn(name = "nr_rm", nullable = false)
    private Aluno aluno;
}
