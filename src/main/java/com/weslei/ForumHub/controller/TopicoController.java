package com.weslei.ForumHub.controller;

import com.weslei.ForumHub.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @Autowired
    private TopicoService service;

    @PostMapping
    @Transactional
    public ResponseEntity<Topico> cadastrar(@RequestBody @Valid DadosCadastroTopico dados) {
        try {
            var novoTopico = service.cadastrarTopico(dados);
            return ResponseEntity.ok(novoTopico);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping
    public Page<DadosListagemTopico> listar(@PageableDefault(size = 10, sort = {"dataCriacao"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemTopico::new);
    }
}
