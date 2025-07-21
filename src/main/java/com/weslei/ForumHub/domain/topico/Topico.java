package com.weslei.ForumHub.domain.topico;

import com.weslei.ForumHub.domain.resposta.Resposta;
import com.weslei.ForumHub.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@Setter
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

    @Enumerated(EnumType.STRING)
    @Setter
    private StatusTopico status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Resposta> respostas = new ArrayList<>();


    public Topico(DadosCadastroTopico dados, Usuario autor) {
        this.mensagem = dados.mensagem();
        this.nomeCurso = dados.nomeCurso();
        this.titulo = dados.titulo();
        this.dataCriacao = LocalDateTime.now();
        this.status = StatusTopico.NAO_RESPONDIDO;
        this.autor = autor;
    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoTopico dados) {
        if (dados.mensagem() != null) {
            this.mensagem = dados.mensagem();
        }
        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
        if (dados.nomeCurso() != null) {
            this.nomeCurso = dados.nomeCurso();
        }
        if (dataCriacao != null) {
            this.dataCriacao = LocalDateTime.now();
        }
    }
}
