package com.weslei.ForumHub.topico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository repository;

    public Topico cadastrarTopico(DadosCadastroTopico dados){
        if (repository.findByTituloAndMensagem(dados.titulo(), dados.mensagem()).isPresent()) {
            throw new IllegalArgumentException("Um tópico com o mesmo titulo e mensagem JA EXISTE.");
        }

        var novoTopico = new Topico(dados);
        return repository.save(novoTopico);
    }
}
