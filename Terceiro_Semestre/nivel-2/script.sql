CREATE SCHEMA `loja` ;

use loja;


CREATE TABLE compra (
  id_compra INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  id_comprador_user INTEGER UNSIGNED NOT NULL,
  id_fornecedor INTEGER UNSIGNED NOT NULL,
  data_compra DATE NULL,
  quant_comprada INTEGER UNSIGNED NULL,
  cod_produto INTEGER UNSIGNED NULL,
  nome VARCHAR(255) NULL,
  PRIMARY KEY(id_compra),
  INDEX compra_FKIndex1(id_fornecedor),
  INDEX compra_FKIndex2(id_comprador_user)
);

CREATE TABLE endereco (
  id_end INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  id_user INTEGER UNSIGNED NOT NULL,
  id_tipo INTEGER UNSIGNED NULL DEFAULT NULL,
  endereco VARCHAR(255) NULL,
  n_end VARCHAR(10) NULL,
  bairro_end VARCHAR(45) NULL,
  cidade VARCHAR(45) NULL,
  uf VARCHAR(2) NULL,
  cep VARCHAR(45) NULL,
  PRIMARY KEY(id_end),
  INDEX endereco_FKIndex1(id_tipo),
  INDEX endereco_FKIndex2(id_user)
);

CREATE TABLE pessoa (
  id_pessoa INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  id_user INTEGER UNSIGNED NOT NULL,
  id_tipo INTEGER UNSIGNED NULL DEFAULT NULL,
  nome VARCHAR(255) NULL,
  PRIMARY KEY(id_pessoa),
  INDEX pessoa_FKIndex1(id_tipo),
  INDEX pessoa_FKIndex2(id_user)
);

CREATE TABLE pf (
  id_pf INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  cpf VARCHAR(255) NOT NULL,
  id_pessoa INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(id_pf),
  INDEX pf_FKIndex1(id_pessoa)
);

CREATE TABLE pj (
  id_pj INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  cnpj VARCHAR(255) NOT NULL,
  id_pessoa INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(id_pj),
  INDEX pj_FKIndex1(id_pessoa)
);

CREATE TABLE produtos (
  id_produto INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  id_fornecedor INTEGER UNSIGNED NULL DEFAULT NULL,
  id_user INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(255) NOT NULL,
  quantidade INTEGER UNSIGNED NULL,
  preco_venda DECIMAL NULL,
  data_compra DATE NOT NULL,
  PRIMARY KEY(id_produto),
  INDEX Table_Produtos_FKIndex1(id_user),
  INDEX Table_Produtos_FKIndex2(id_fornecedor)
);

CREATE TABLE senhas (
  id_senha INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  id_user INTEGER UNSIGNED NOT NULL,
  senha VARCHAR(225) NOT NULL,
  login VARCHAR(255) NOT NULL,
  PRIMARY KEY(id_senha),
  INDEX senhas_FKIndex1(id_user)
);

CREATE TABLE telefones (
  id_telefone INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  id_user INTEGER UNSIGNED NOT NULL,
  id_tipo INTEGER UNSIGNED NOT NULL,
  numero VARCHAR(20) NULL,
  PRIMARY KEY(id_telefone),
  INDEX telefones_FKIndex3(id_tipo),
  INDEX telefones_FKIndex2(id_user)
);

CREATE TABLE tipo_end (
  id_tipo_end INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome INTEGER UNSIGNED NULL,
  PRIMARY KEY(id_tipo_end)
);

CREATE TABLE tipo_pessoa (
  id_tipo_pessoa INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome INTEGER UNSIGNED NULL,
  PRIMARY KEY(id_tipo_pessoa)
);

CREATE TABLE tipo_telefone (
  id_tipo_telefone INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(255) NULL,
  PRIMARY KEY(id_tipo_telefone)
);

CREATE TABLE tipo_usuario (
  id_tipo INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  id_user INTEGER UNSIGNED NOT NULL,
  nome INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY(id_tipo),
  INDEX tipo_usuario_FKIndex1(id_user)
);

CREATE TABLE usuarios (
  id_user INTEGER UNSIGNED NOT NULL,
  id_tipo INTEGER UNSIGNED NULL DEFAULT NULL,
  nome VARCHAR(255) NOT NULL,
  PRIMARY KEY(id_user),
  INDEX usuarios_FKIndex1(id_tipo)
);

CREATE TABLE vendas (
  id_venda INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  id_consumidor_pj INTEGER UNSIGNED NULL DEFAULT NULL,
  id_consumidor_pf INTEGER UNSIGNED NULL DEFAULT NULL,
  id_vendedor INTEGER UNSIGNED NOT NULL,
  id_produto INTEGER UNSIGNED NOT NULL,
  quant_vendida INTEGER UNSIGNED NULL,
  data_venda DATE NULL,
  PRIMARY KEY(id_venda),
  INDEX Table_vendas_FKIndex1(id_produto),
  INDEX Table_vendas_FKIndex2(id_consumidor_pf),
  INDEX Table_vendas_FKIndex3(id_vendedor),
  INDEX Table_vendas_FKIndex4(id_consumidor_pj)
);


