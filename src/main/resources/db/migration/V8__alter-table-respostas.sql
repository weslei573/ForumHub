CREATE TABLE respostas (
    id BIGINT NOT NULL AUTO_INCREMENT,
    mensagem VARCHAR(1000) NOT NULL,
    data_criacao DATETIME NOT NULL,
    solucao TINYINT NOT NULL DEFAULT 0,

    topico_id BIGINT NOT NULL,
    autor_id BIGINT NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (topico_id) REFERENCES topicos(id),
    FOREIGN KEY (autor_id) REFERENCES usuarios(id)

);