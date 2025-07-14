package com.weslei.ForumHub.controller;

import com.weslei.ForumHub.topico.DadosCadastroTopico;
import com.weslei.ForumHub.topico.Topico;
import com.weslei.ForumHub.topico.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroTopico dados) {
        repository.save(new Topico(dados));
    }
}
