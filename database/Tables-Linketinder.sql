CREATE TABLE pais (
  id SERIAL PRIMARY KEY,
  nome VARCHAR(45) NOT NULL
);

CREATE TABLE candidato (
  id SERIAL PRIMARY KEY,
  nome VARCHAR(40) NOT NULL,
  sobrenome VARCHAR(120) NOT NULL,
  cpf VARCHAR(11) NOT NULL,
  estado VARCHAR(2) NOT NULL,
  cep VARCHAR(8) NOT NULL,
  id_pais INTEGER NOT NULL,
  descricao TEXT NOT NULL,
  senha VARCHAR(30) NOT NULL,
  FOREIGN KEY (id_pais) REFERENCES pais (id)
);

CREATE TABLE empresa (
  id SERIAL PRIMARY KEY,
  nome VARCHAR(40) NOT NULL,
  estado VARCHAR(2) NOT NULL,
  cep VARCHAR(8) NOT NULL,
  id_pais INTEGER NOT NULL,
  senha VARCHAR(30) NOT NULL,
  FOREIGN KEY (id_pais) REFERENCES pais (id)
);

CREATE TABLE vaga (
  id SERIAL PRIMARY KEY,
  nome VARCHAR(20) NOT NULL,
  descricao TEXT NOT NULL,
  id_empresa INTEGER NOT NULL,
  FOREIGN KEY (id_empresa) REFERENCES empresa (id)
);

CREATE TABLE competencias (
  id SERIAL PRIMARY KEY,
  nome VARCHAR(50) NOT NULL
);

CREATE TABLE competencias_vaga (
  id SERIAL PRIMARY KEY,
  id_vaga INTEGER NOT NULL,
  id_competencia INTEGER NOT NULL,
  FOREIGN KEY (id_vaga) REFERENCES vaga (id),
  FOREIGN KEY (id_competencia) REFERENCES competencias (id)
);

CREATE TABLE competencias_candidatos (
  id SERIAL PRIMARY KEY,
  id_candidato INTEGER NOT NULL,
  id_competencia INTEGER NOT NULL,
  FOREIGN KEY (id_candidato) REFERENCES candidato (id),
  FOREIGN KEY (id_competencia) REFERENCES competencias (id)
);
