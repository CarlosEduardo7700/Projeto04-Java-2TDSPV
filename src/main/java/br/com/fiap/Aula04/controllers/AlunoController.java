package br.com.fiap.Aula04.controllers;

import br.com.fiap.Aula04.dtos.AtualizarAlunoDto;
import br.com.fiap.Aula04.dtos.CadastroAlunoDto;
import br.com.fiap.Aula04.dtos.DetalhesAlunoDto;
import br.com.fiap.Aula04.dtos.ListagemAlunoDto;
import br.com.fiap.Aula04.models.Aluno;
import br.com.fiap.Aula04.repositories.AlunoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @GetMapping
    public ResponseEntity<List<ListagemAlunoDto>> buscarTudo(Pageable pageable) {
        var listaDto = repository.findAll(pageable)
                .stream().map(ListagemAlunoDto::new).toList();
        return ResponseEntity.ok(listaDto);

    }

    @GetMapping("{rm}")
    public ResponseEntity<DetalhesAlunoDto> buscarPorRm(@PathVariable("rm") Long rm) {
        var aluno = repository.getReferenceById(rm);
        return ResponseEntity.ok(new DetalhesAlunoDto(aluno));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesAlunoDto> inserir(@RequestBody @Valid CadastroAlunoDto dto, UriComponentsBuilder builder) {
        Aluno aluno = new Aluno(dto);
        repository.save(aluno);

        URI uri = builder.path("/alunos/{rm}").buildAndExpand(aluno.getRm()).toUri();

        return ResponseEntity.created(uri).body(new DetalhesAlunoDto(aluno));
    }

    @PutMapping("{rm}")
    @Transactional
    public ResponseEntity<DetalhesAlunoDto> atualizar(@PathVariable("rm") Long rm, @RequestBody AtualizarAlunoDto dto) {
        var aluno = repository.getReferenceById(rm);
        aluno.atualizarDados(dto);

        return ResponseEntity.ok(new DetalhesAlunoDto(aluno));
    }

    @DeleteMapping("{rm}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable("rm") Long rm) {
        repository.deleteById(rm);
        return ResponseEntity.noContent().build();
    }
}
