package com.weslei.ForumHub.controller;

import com.weslei.ForumHub.domain.resposta.DadosCadastroResposta;
import com.weslei.ForumHub.domain.resposta.DadosDetalhamentoResposta;
import com.weslei.ForumHub.domain.resposta.RespostaService;
import com.weslei.ForumHub.domain.usuario.Usuario;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/respostas")
@SecurityRequirement(name = "bearer-key")
public class RespostaController {

    @Autowired
    private RespostaService service;

    @PostMapping
    @Transactional
    public ResponseEntity responderTopico(
            @RequestBody @Valid DadosCadastroResposta dados,
            UriComponentsBuilder uriBuilder,
            Authentication authentication
            ){
        Usuario autorLogado = (Usuario) authentication.getPrincipal();

        var resposta = service.criarResposta(dados, autorLogado);

        var uri = uriBuilder.path("/respostas/{id}").buildAndExpand(resposta.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoResposta(resposta));

    }
}
