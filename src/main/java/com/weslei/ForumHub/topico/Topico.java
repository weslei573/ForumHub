package com.weslei.ForumHub.topico;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensagem;
    private String nomeCurso;
    private String titulo;
    private LocalDateTime dataCriacao;

    private Boolean status;

    public Topico(DadosCadastroTopico dados) {
        this.status = true;
        this.mensagem = dados.mensagem();
        this.nomeCurso = dados.nomeCurso();
        this.titulo = dados.titulo();
        this.dataCriacao = LocalDateTime.now();
    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoTopico dados) {
        if (dados.mensagem() != null){
            this.mensagem = dados.mensagem();
        }
        if (dados.titulo() != null){
            this.titulo = dados.titulo();
        }
        if (dados.nomeCurso() != null){
            this.nomeCurso = dados.nomeCurso();
        }
        if (dataCriacao != null){
            this.dataCriacao = LocalDateTime.now();
        }
    }

    public void deletar() {
        this.status = false;
    }
}
