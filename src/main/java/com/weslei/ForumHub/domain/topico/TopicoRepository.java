package com.weslei.ForumHub.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    Optional<Topico> findByTituloAndMensagem(String titulo, String mensagem);

    @Query("""
        SELECT t FROM Topico t
        WHERE t.titulo = :titulo
        AND t.mensagem = :mensagem
        AND t.id <> :id
    """)
    Optional<Topico> findByTituloAndMensagemAndIdNot(@Param("titulo") String titulo, @Param("mensagem") String mensagem, @Param("id") Long id);

    @Query("SELECT t FROM Topico t WHERE t.nomeCurso = :nomeCurso AND FUNCTION('YEAR', t.dataCriacao) = :ano")
    List<Topico> findByNomeCursoAndAnoDataCriacao(@Param("nomeCurso") String nomeCurso, @Param("ano") int ano);


}
