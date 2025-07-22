package com.weslei.ForumHub.domain.topico;

import com.weslei.ForumHub.domain.resposta.DadosListagemResposta;
import com.weslei.ForumHub.domain.resposta.Resposta;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record DadosDetalhamentoTopico(
        Long id,
        String titulo,
        String mensagem,
        String nomeCurso,
        LocalDateTime dataCriacao,
        StatusTopico status,
        String autorNome,
        List<DadosListagemResposta> respostas
        ) {
    public DadosDetalhamentoTopico(Topico topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getNomeCurso(),
                topico.getDataCriacao(),
                topico.getStatus(),
                topico.getAutor() != null ? topico.getAutor().getLogin() : null,
                topico.getRespostas().stream()
                        .map(DadosListagemResposta::new)
                        .collect(Collectors.toList())
        );
    }
}
