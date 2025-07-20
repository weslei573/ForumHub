package com.weslei.ForumHub.domain.topico;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopico(
        Long id,
        String titulo,
        String mensagem,
        String nomeCurso,
        LocalDateTime dataCriacao,
        StatusTopico status,
        String autorNome
        ) {
    public DadosDetalhamentoTopico(Topico topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getNomeCurso(),
                topico.getDataCriacao(),
                topico.getStatus(),
                topico.getAutor() != null ? topico.getAutor().getLogin() : null
        );
    }
}
