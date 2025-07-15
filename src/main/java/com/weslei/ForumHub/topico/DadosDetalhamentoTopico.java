package com.weslei.ForumHub.topico;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopico(
        Long id,
        String titulo,
        String mensagem,
        String nomeCurso,
        LocalDateTime dataCriacao
        ) {
    public DadosDetalhamentoTopico(Topico topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getNomeCurso(),
                topico.getDataCriacao()
        );
    }
}
