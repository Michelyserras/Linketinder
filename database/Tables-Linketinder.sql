
CREATE TABLE IF NOT EXISTS candidato (
  id SERIAL PRIMARY KEY,
  nome VARCHAR(40) NOT NULL,
  sobrenome VARCHAR(120) NOT NULL,
  cpf VARCHAR(11) NOT NULL,
  idade INTEGER NOT NULL,
  estado VARCHAR(2) NOT NULL,
  cep VARCHAR(8) NOT NULL,
  pais VARCHAR(45) NOT NULL,
  descricao TEXT NOT NULL,
  email VARCHAR(100) NOT NULL,
  senha VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS empresa (
  id SERIAL PRIMARY KEY,
  nome VARCHAR(40) NOT NULL,
  cnpj VARCHAR(14) NOT NULL,
  estado VARCHAR(2) NOT NULL,
  cep VARCHAR(8) NOT NULL,
  pais VARCHAR(45) NOT NULL,
  descricao TEXT NOT NULL,
  email VARCHAR(100) NOT NULL,
  senha VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS vaga (
  id SERIAL PRIMARY KEY,
  nome VARCHAR(20) NOT NULL,
  descricao TEXT NOT NULL,
  localidade VARCHAR(50) NOT NULL,
  id_empresa INTEGER NOT NULL,
  FOREIGN KEY (id_empresa) REFERENCES empresa (id)
);

CREATE TABLE IF NOT EXISTS competencias (
  id SERIAL PRIMARY KEY,
  nome VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS competencias_vaga (
  id SERIAL PRIMARY KEY,
  id_vaga INTEGER NOT NULL,
  id_competencia INTEGER NOT NULL,
  FOREIGN KEY (id_vaga) REFERENCES vaga (id),
  FOREIGN KEY (id_competencia) REFERENCES competencias (id)
);

CREATE TABLE IF NOT EXISTS competencias_candidatos (
  id SERIAL PRIMARY KEY,
  id_candidato INTEGER NOT NULL,
  id_competencia INTEGER NOT NULL,
  FOREIGN KEY (id_candidato) REFERENCES candidato (id),
  FOREIGN KEY (id_competencia) REFERENCES competencias (id)
);
