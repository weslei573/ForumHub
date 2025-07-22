package com.weslei.ForumHub.domain.resposta;

import java.time.LocalDateTime;

public record DadosListagemResposta(
        String mensagem,
        LocalDateTime dataCriacao,
        String autorNome
) {
    public DadosListagemResposta(Resposta resposta) {
        this(
                resposta.getMensagem(),
                resposta.getDataCriacao(),
                resposta.getAutor() != null ? resposta.getAutor().getUsername() : null // Use .getLogin() ou o método correto
        );
    }
}
