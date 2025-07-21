package com.weslei.ForumHub.domain.resposta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroResposta(
        @NotBlank
        String mensagem,
        @NotNull
        Long topicoId
) {
}
