package com.weslei.ForumHub.topico;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTopico(
        @NotNull
        Long id,
        String mensagem,
        String nomeCurso,
        String titulo
) {
}
