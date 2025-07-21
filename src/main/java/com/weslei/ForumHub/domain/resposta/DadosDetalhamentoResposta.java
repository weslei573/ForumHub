package com.weslei.ForumHub.domain.resposta;

import java.time.LocalDateTime;

public record DadosDetalhamentoResposta(
        Long id,
        String mensagem,
        LocalDateTime dataCriacao,
        Boolean solucao,
        Long topicoId,
        String topicoTitulo,
        String autorNome
) {
    public DadosDetalhamentoResposta(Resposta resposta){
        this(
                resposta.getId(),
                resposta.getMensagem(),
                resposta.getDataCriacao(),
                resposta.getSolucao(),
                resposta.getTopico().getId(),
                resposta.getTopico().getTitulo(),
                resposta.getAutor().getUsername()
        );
    }
}
