USE loja;

INSERT INTO usuarios (`login`, `senha`) VALUES
('alice', 'password123'),
('bob', 'passw0rd456'),
('charlie', 'secure789pass'),
('david', 'user5678pass'),
('emma', '1234password'),
('frank', 'password999'),
('grace', 'pass1234word'),
('henry', 'secure6543pass'),
('isabella', '456password'),
('jack', 'passwor7d89'),
('lily', 'password1230'),
('mason', '1secure2pass'),
('natalie', 'user123456'),
('oliver', 'passwo3rd456'),
('penny', 'password78'),
('quinn', 'secure1pass2'),
('riley', '123password45'),
('samuel', 'password6'),
('trinity', 'secure12345'),
('olivia', 'password7890'),
('william', 'passw123ord');


INSERT INTO produtos (`idMovimento`, `idUsuario`, `nome`, `quantidade`, `precoVendas`) VALUES
(1, 1, 'ARROZ', 10, 5.00),
(8, 2, 'FEIJÃO', 20, 12.00),
(5, 3, 'MACARRÃO', 15, 8.50),
(14, 4, 'ÓLEO DE COZINHA', 12, 10.00),
(3, 5, 'SAL', 30, 4.50),
(12, 1, 'AÇÚCAR', 25, 7.00),
(7, 2, 'CAFÉ', 10, 15.00),
(9, 3, 'LEITE', 8, 11.50),
(18, 4, 'BISCOITOS', 18, 6.00),
(11, 5, 'CERVEJA', 15, 12.00),
(20, 1, 'REFRIGERANTE', 20, 9.50),
(6, 2, 'FRANGO', 14, 13.00),
(2, 3, 'CARNE BOVINA', 10, 14.50),
(13, 4, 'PEIXE', 5, 16.00),
(4, 5, 'LEGUMES', 30, 5.50),
(10, 1, 'FRUTAS', 25, 10.00),
(15, 2, 'BOLACHAS', 12, 11.50),
(19, 3, 'MOLHO DE TOMATE', 18, 7.00),
(17, 4, 'IOGURTE', 20, 8.50),
(16, 5, 'PAPEL HIGIÊNICO', 15, 6.00);



INSERT INTO pessoaJuridica (`idUsuario`, `nome`, `logradouro`, `cidade`, `estado`, `telefone`, `email`, `cnpj`) VALUES
(2, 'Empresa1 LTDA', 'Rua A', 'Belém', 'PA', '919911122233', 'empresa1@gmail.com', '12345678901234'),
(3, 'Empresa2 LTDA', 'Rua B', 'Belém', 'PA', '919922233344', 'empresa2@gmail.com', '23456789012345'),
(4, 'Empresa3 LTDA', 'Rua C', 'Belém', 'PA', '919933344455', 'empresa3@gmail.com', '34567890123456'),
(5, 'Empresa4 LTDA', 'Rua D', 'Belém', 'PA', '919944455566', 'empresa4@gmail.com', '45678901234567'),
(1, 'Empresa5 LTDA', 'Rua E', 'Belém', 'PA', '919955566677', 'empresa5@gmail.com', '56789012345678'),
(2, 'Empresa6 LTDA', 'Rua F', 'Belém', 'PA', '919966677788', 'empresa6@gmail.com', '67890123456789'),
(3, 'Empresa7 LTDA', 'Rua G', 'Belém', 'PA', '919977788899', 'empresa7@gmail.com', '78901234567890'),
(4, 'Empresa8 LTDA', 'Rua H', 'Belém', 'PA', '919988899900', 'empresa8@gmail.com', '89012345678901'),
(5, 'Empresa9 LTDA', 'Rua I', 'Belém', 'PA', '919999000011', 'empresa9@gmail.com', '90123456789012'),
(1, 'Empresa10 LTDA', 'Rua J', 'Belém', 'PA', '919900001122', 'empresa10@gmail.com', '01234567890123');



INSERT INTO pessoaFisica (`nome`, `logradouro`, `cidade`, `estado`, `telefone`, `email`, `idUsuario`, `cpf`) VALUES
('Isabel Santos', 'Rua das Acácias', 'Belém', 'PA', '9199888999', 'isabel@gmail.com', '2', '98765432109'),
('Ricardo Silva', 'Avenida das Mangueiras', 'Belém', 'PA', '9199777888', 'ricardo@gmail.com', '3', '87654321098'),
('Lucia Fernandes', 'Travessa José do O', 'Belém', 'PA', '9199666777', 'lucia@gmail.com', '4', '76543210987'),
('Bruno Mendes', 'Rua dos Pinheiros', 'Belém', 'PA', '9199555666', 'bruno@gmail.com', '5', '65432109876'),
('Silvia Nunes', 'Avenida das Palmeiras', 'Belém', 'PA', '9199444555', 'silvia@gmail.com', '1', '54321098765'),
('Fernando Lima', 'Rua das Palmas', 'Belém', 'PA', '9199333444', 'fernando@gmail.com', '2', '43210987654'),
('Carla Alves', 'Travessa dos Coqueiros', 'Belém', 'PA', '9199223333', 'carla@gmail.com', '3', '32109876543'),
('Hugo Pereira', 'Avenida dos Ipês', 'Belém', 'PA', '9199111222', 'hugo@gmail.com', '4', '21098765432'),
('Eva Rocha', 'Rua das Orquídeas', 'Belém', 'PA', '9199000011', 'eva@gmail.com', '5', '10987654321');





INSERT INTO movimento(`idUsuarios`, `idPJ`, `idProdutos`, `quantidade`, `tipo`, `valorUnitario`) VALUES 
(1, 5, 3, 5, 'E', 10.00),
(2, 1, 6, 3, 'E', 15.00),
(3, 2, 2, 8, 'E', 7.50),
(4, 3, 10, 2, 'E', 12.00),
(5, 4, 4, 6, 'E', 9.00),
(1, 2, 7, 7, 'E', 11.00),
(2, 3, 5, 4, 'E', 14.00),
(3, 1, 8, 9, 'E', 6.50),
(4, 5, 1, 1, 'E', 13.00),
(5, 4, 9, 5, 'E', 8.00),
(1, 1, 5, 7, 'E', 11.50),
(2, 5, 8, 4, 'E', 9.50),
(3, 4, 10, 6, 'E', 14.00),
(4, 2, 3, 10, 'E', 12.50),
(5, 3, 6, 8, 'E', 13.50),
(1, 3, 1, 3, 'E', 10.50),
(2, 4, 4, 9, 'E', 15.50),
(3, 5, 7, 2, 'E', 8.50),
(4, 1, 2, 5, 'E', 17.50),
(5, 2, 9, 1, 'E', 11.50);


INSERT INTO movimento (`idUsuarios`, `idPF`, `idProdutos`, `quantidade`, `tipo`, `valorUnitario`) VALUES 
(1, 5, 3, 5, 'S', 10.00),
(2, 1, 6, 3, 'S', 15.00),
(3, 2, 2, 8, 'S', 7.50),
(4, 3, 10, 2, 'S', 12.00),
(5, 4, 4, 6, 'S', 9.00),
(1, 2, 7, 7, 'S', 11.00),
(2, 3, 5, 4, 'S', 14.00),
(3, 1, 8, 9, 'S', 6.50),
(4, 5, 1, 1, 'S', 13.00),
(5, 4, 9, 5, 'S', 8.00),
(1, 1, 5, 7, 'S', 11.50),
(2, 5, 8, 4, 'S', 9.50),
(3, 4, 10, 6, 'S', 14.00),
(4, 2, 3, 10, 'S', 12.50),
(5, 3, 6, 8, 'S', 13.50),
(1, 3, 1, 3, 'S', 10.50),
(2, 4, 4, 9, 'S', 15.50),
(3, 5, 7, 2, 'S', 8.50),
(4, 1, 2, 5, 'S', 17.50),
(5, 2, 9, 1, 'S', 11.50);




