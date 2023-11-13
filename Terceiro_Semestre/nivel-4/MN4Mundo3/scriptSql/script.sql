CREATE SCHEMA `loja` ;

use loja;


CREATE TABLE produtos (
  id_produto INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  id_user INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(255) NOT NULL,
  quantidade INTEGER UNSIGNED NULL,
  preco_venda DECIMAL NULL,
  data_compra DATE NOT NULL,
  PRIMARY KEY(id_produto),
  INDEX Table_Produtos_FKIndex1(id_user)
);

CREATE TABLE usuarios (
  id_user INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  senha VARCHAR(255) NULL,
  PRIMARY KEY(id_user)
);

