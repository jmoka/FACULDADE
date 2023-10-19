USE loja;

CREATE TABLE movimento (
  idMovimento INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  idUsuarios INTEGER UNSIGNED NOT NULL,
  idPJ INTEGER UNSIGNED NULL,
  idPF INTEGER UNSIGNED NULL,
  idProdutos INTEGER UNSIGNED NULL,
  quantidade INTEGER UNSIGNED NULL,
  tipo VARCHAR(1) NULL,
  valorUnitario DOUBLE NULL,
  PRIMARY KEY(idMovimento),
  INDEX movimento_FKIndex1(idPJ),
  INDEX movimento_FKIndex2(idPF),
  INDEX movimento_FKIndex3(idUsuarios)
);

CREATE TABLE pessoaFisica (
  idPessoaFisica INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255) NULL,
  logradouro VARCHAR(255) NULL,
  cidade VARCHAR(255) NULL,
  estado VARCHAR(20) NULL,
  telefone VARCHAR(255) NULL,
  email VARCHAR(255) NULL,
  idUsuario INTEGER UNSIGNED NULL,
  cpf VARCHAR(255) NULL,
  PRIMARY KEY(idPessoaFisica),
  INDEX pessoaFisica_FKIndex1(idUsuario)
);

CREATE TABLE pessoaJuridica (
  idPessoaJuridica INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  idUsuario INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(255) NULL,
  logradouro VARCHAR(255) NULL,
  cidade VARCHAR(255) NULL,
  estado VARCHAR(20) NULL,
  telefone VARCHAR(255) NULL,
  email VARCHAR(255) NULL,
  cnpj VARCHAR(255) NULL,
  PRIMARY KEY(idPessoaJuridica),
  INDEX pessoaJuridica_FKIndex1(idUsuario)
);

CREATE TABLE produtos (
  idProdutos INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  idMovimento INTEGER UNSIGNED NOT NULL,
  idUsuario INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(255) NULL,
  quantidade INTEGER UNSIGNED NULL,
  precoVendas DOUBLE NULL,
  PRIMARY KEY(idProdutos),
  INDEX produtos_FKIndex1(idUsuario),
  INDEX produtos_FKIndex2(idMovimento)
);

CREATE TABLE usuarios (
  idUsuario INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  login VARCHAR(255) NULL,
  senha VARCHAR(255) NULL,
  PRIMARY KEY(idUsuario)
);


