package com.weslei.ForumHub.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroTopico(
        @NotBlank
        String mensagem,
        @NotBlank
        String nomeCurso,
        @NotBlank
        String titulo
) {
}
