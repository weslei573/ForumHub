package com.weslei.ForumHub.domain.resposta;

import com.weslei.ForumHub.domain.topico.TopicoRepository;
import com.weslei.ForumHub.domain.usuario.Usuario;
import com.weslei.ForumHub.domain.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RespostaService {

    @Autowired
    private RespostaRepository repository;
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public Resposta criarResposta(DadosCadastroResposta dados, Usuario autor){
        var topico = topicoRepository.findById(dados.topicoId())
                .orElseThrow(() -> new IllegalArgumentException("Topico com ID " + dados.topicoId() + " não encontrado"));

        var novaResposta = new Resposta(dados.mensagem(), topico, autor);

        if (topico.getStatus() == com.weslei.ForumHub.domain.topico.StatusTopico.NAO_RESPONDIDO){
            topico.setStatus(com.weslei.ForumHub.domain.topico.StatusTopico.RESPONDIDO);
        }

        return repository.save(novaResposta);
    }
}
