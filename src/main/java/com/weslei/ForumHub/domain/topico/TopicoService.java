package com.weslei.ForumHub.domain.topico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
