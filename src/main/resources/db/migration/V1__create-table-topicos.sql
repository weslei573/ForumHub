CREATE TABLE topicos (

    id BIGINT NOT NULL AUTO_INCREMENT,

    mensagem VARCHAR(300) NOT NULL,

    nome_curso VARCHAR(255),

    titulo VARCHAR(255) NOT NULL,

    data_criacao DATETIME(6) NOT NULL,



    PRIMARY KEY (id)

);