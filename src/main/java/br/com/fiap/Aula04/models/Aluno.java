package br.com.fiap.Aula04.models;

import br.com.fiap.Aula04.dtos.AtualizarAlunoDto;
import br.com.fiap.Aula04.dtos.CadastroAlunoDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "JV_ALUNO")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Aluno {

    @Id
    @GeneratedValue
    @Column(name = "nr_rm")
    private Long rm;

    @Column(name = "nm_aluno", length = 100, nullable = false)
    private String nome;

    @Column(name = "nr_cpf", length = 11, nullable = false, unique = true)
    private String cpf;

    @Column(name = "dt_nascimento", nullable = false)
    private LocalDate dataDeNascimento;

    @CreatedDate
    @Column(name = "dt_cadastro", nullable = false)
    private LocalDateTime dataDeCadastro;

    @Enumerated(EnumType.STRING)
    @Column(name = "de_nivel_escolaridade", nullable = false, length = 30)
    private NivelDeEscolaridade nivelDeEscolaridade;

    @Column(name = "vl_renda", precision = 7)
    private Double renda;

    @Transient
    private Integer idade;

    @OneToOne(mappedBy = "aluno", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Carteirinha carteirinha;

    public Aluno(CadastroAlunoDto dto) {
        this.nome = dto.nome();
        this.cpf = dto.cpf();
        this.dataDeNascimento = dto.dataDeNascimento();
        this.nivelDeEscolaridade = dto.nivelDeEscolaridade();
        this.renda = dto.renda();
    }

    public void atualizarDados(AtualizarAlunoDto dto) {
        if (dto.nome() != null)
            this.nome = dto.nome();
        if (dto.dataDeNascimento() != null)
            this.dataDeNascimento = dto.dataDeNascimento();
        if (dto.nivelDeEscolaridade() != null)
            this.nivelDeEscolaridade = dto.nivelDeEscolaridade();
        if (dto.renda() != null)
            this.renda = dto.renda();
    }
}
