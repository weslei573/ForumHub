package com.weslei.ForumHub.domain.topico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public Topico cadastrarTopico(DadosCadastroTopico dados) {
        if (topicoRepository.findByTituloAndMensagem(dados.titulo(), dados.mensagem()).isPresent()) {
            throw new IllegalArgumentException("Um tópico com o mesmo TÍTULO e MENSAGEM já existe.");
        }

        Topico novoTopico = new Topico(dados);
        return topicoRepository.save(novoTopico);
    }

    @Transactional
    public Topico atualizarTopico(DadosAtualizacaoTopico dados) {
        Optional<Topico> topicoOptional = topicoRepository.findById(dados.id());
        if (topicoOptional.isEmpty()) {
            throw new IllegalArgumentException("Tópico com ID " + dados.id() + " não encontrado.");
        }

        Topico topico = topicoOptional.get();

        boolean tituloOuMensagemAlterados = (dados.titulo() != null && !dados.titulo().equals(topico.getTitulo())) ||
                (dados.mensagem() != null && !dados.mensagem().equals(topico.getMensagem()));

        if (tituloOuMensagemAlterados) {
             if (topicoRepository.findByTituloAndMensagemAndIdNot(dados.titulo(), dados.mensagem(), dados.id()).isPresent()) {
                throw new IllegalArgumentException("Não é possível atualizar: Já existe outro tópico com o mesmo título e mensagem.");
            }
        }

        topico.atualizarInformacoes(dados);

        return topico;
    }
}
