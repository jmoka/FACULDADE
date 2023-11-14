CREATE SCHEMA cadastropessoas;

use cadastropessoas;

CREATE TABLE PessoaFisica (
  idPessoaFisica INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
   nome VARCHAR(255) NULL,
  logradouro VARCHAR(255) NULL,
  cidade VARCHAR(255) NULL,
  estado VARCHAR(255) NULL,
  telefone VARCHAR(255) NULL,
  email VARCHAR(255) NULL,
  idUsuarioResponsavel INTEGER UNSIGNED NOT NULL,
  cpf VARCHAR(255) NULL,
  PRIMARY KEY(idPessoaFisica),
  INDEX PessoaFisica_FKIndex1(idUsuarioResponsavel)
);

CREATE TABLE PessoaJuridica (
  idPessoaJuridica INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255) NULL,
  logradouro VARCHAR(255) NULL,
  cidade VARCHAR(255) NULL,
  estado VARCHAR(255) NULL,
  telefone VARCHAR(255) NULL,
  email VARCHAR(255) NULL,
  idUsuarioResponsavel INTEGER UNSIGNED NOT NULL,
  cnpj VARCHAR(255) NULL,
  PRIMARY KEY(idPessoaJuridica),
  INDEX PessoaJuridica_FKIndex1(idUsuarioResponsavel)
);

CREATE TABLE Usuarios (
  idUsuario INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255) NULL,
  senha VARCHAR(255) NULL,
  PRIMARY KEY(idUsuario)
);


