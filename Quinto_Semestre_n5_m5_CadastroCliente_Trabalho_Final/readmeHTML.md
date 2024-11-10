<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Projeto de Desenvolvimento Full Stack</title>
<link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700,900" rel="stylesheet">
<style>
    body {
        font-family: 'Roboto', sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f7f6;
    }
    header {
        background-color: #1976d2;
        color: white;
        padding: 1rem;
        text-align: center;
    }
    header h1 {
        margin: 0;
    }
    nav {
        display: flex;
        justify-content: center;
        background-color: #1565c0;
        padding: 1rem;
    }
    nav a {
        color: white;
        text-decoration: none;
        padding: 0.5rem 1rem;
        margin: 0 1rem;
    }
    nav a:hover {
        background-color: #0d47a1;
        border-radius: 5px;
    }
    .carousel {
        display: flex;
        overflow: hidden;
        width: 100%;
        justify-content: center;
        margin: 2rem 0;
    }
    .carousel img {
        max-width: 100%;
        height: auto;
        margin: 0 1rem;
        transition: transform 0.3s ease-in-out;
    }
    .carousel img:hover {
        transform: scale(1.1);
    }
    .container {
        padding: 2rem;
    }
    .flex-row {
        display: flex;
        flex-wrap: wrap;
    }
    .flex-col {
        flex: 1;
        padding: 1rem;
    }
    .section-title {
        font-size: 1.5rem;
        color: #1976d2;
        margin-bottom: 1rem;
    }
    .section-text {
        font-size: 1rem;
        line-height: 1.6;
    }
    .highlight {
        font-weight: bold;
    }
    .card {
        background-color: #fff;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
        padding: 1.5rem;
        margin-bottom: 1.5rem;
    }
    .list {
        padding-left: 1rem;
    }
    .list li {
        margin-bottom: 0.5rem;
    }
    .code {
        background-color: #f4f4f4;
        padding: 1rem;
        border-radius: 5px;
        font-family: monospace;
        color: #333;
    }
    .steps {
        padding-left: 1rem;
    }
    .steps li {
        margin-bottom: 1rem;
    }
    .steps li code {
        font-size: 1.1rem;
    }
    footer {
        background-color: #1976d2;
        color: white;
        text-align: center;
        padding: 1rem;
        margin-top: 2rem;
    }
</style>
</head>
<body>

<header>
<h1>Projeto Full Stack</h1>
</header>

<nav>
<a href="#querys">Queries</a>
<a href="#mutations">Mutations</a>
</nav>

<!-- Carrossel de Imagens -->
<div class="carousel">
<img src="path/to/image1.jpg" alt="Tecnologia 1" />
<img src="path/to/image2.jpg" alt="Tecnologia 2" />
<img src="path/to/image3.jpg" alt="Tecnologia 3" />
</div>

<!-- Apresentação -->
<div class="container">
<div class="flex-row">
<div class="flex-col">
    <img src="sua-imagem.jpg" alt="João Luiz" width="100%" />
</div>
<div class="flex-col">
    <h2>João Luiz Silva Tavares</h2>
    <p class="section-text">Durante dois anos de estudo na Faculdade Estácio de Sá, desenvolvi habilidades que me permitem criar sistemas seguros, com foco na proteção de dados e no controle de acesso robusto.</p>
</div>
</div>
</div>

<!-- Seções de Queries e Mutations -->
<div class="container" id="querys">
<h2 class="section-title">Querys</h2>
<div class="card">
<p class="code">query { usuarios { id, nome, email, perfil { nome, rotulo }, status, dataCriacao } }</p>
<p class="code">query { usuarioID(id:1) { id, nome, email, status, perfil { id, nome, rotulo }, dataCriacao } }</p>
</div>
</div>

<div class="container" id="mutations">
<h2 class="section-title">Mutations</h2>
<div class="card">
<p class="code">mutation { loginUsuario(dados: { email: "master@jotaempresa.com", senha: "Master@123" }) { id, nome, email, status, perfil { nome, rotulo } } }</p>
<p class="code">mutation { novoUsuario(user: { nome: "dev", email: "dev41@dev.com", senha: "123", perfil: 4, status: "ATIVO" }) { id, nome, email, perfil { nome, rotulo }, status } }</p>
<p class="code">mutation { alterarUsuario(user: { nome: "brasil2", email: "dev1000@dev.com", status: "ATIVO", perfil: 3 }, filtro: { id: 42 }) { id, nome, email, status, perfil { id, nome, rotulo } } }</p>
<p class="code">mutation { excluirUsuario(filtro: { id: 2 }) { nome, id, email, status, dataCriacao, perfil { nome, rotulo } } }</p>
</div>
</div>

<!-- Informações do Projeto -->
<div class="container">
<h2 class="section-title">Projeto de Desenvolvimento Full Stack - Nível 5: Software Sem Segurança Não Serve</h2>
<p><strong>Faculdade Estácio de Sá</strong><br>
<strong>Curso:</strong> Desenvolvimento Full Stack<br>
<strong>Aluno:</strong> João Luiz Silva Tavares</p>
<p class="section-text">Durante dois anos de estudo nesta instituição respeitada, desenvolvi diversas habilidades que me capacitaram a apresentar este trabalho com confiança. A atividade tem como objetivo demonstrar a criação de um sistema que implementa um alto grau de segurança, com ênfase na proteção de dados sensíveis, controle de acesso robusto e práticas de desenvolvimento seguro.</p>
</div>

<div class="container">
<h3 class="section-title">Objetivos Técnicos da Prática</h3>
<h4>Controle Básico de Acesso a uma API REST</h4>
<p class="section-text">A implementação foi projetada com um sistema de autenticação baseado em tokens (JWT). Esse mecanismo garante que somente usuários autorizados possam acessar recursos protegidos da API, minimizando riscos de acesso não autorizado.</p>

<h4>Tratamento de Dados Sensíveis e Log de Erros</h4>
<ul class="list">
<li><strong>Proteção de Senhas:</strong> Utilização de algoritmos de hashing, como <code>bcrypt</code>.</li>
<li><strong>Log de Erros Seguros:</strong> Configuração para não exibir informações detalhadas que possam ser exploradas por atacantes.</li>
</ul>

<h4>Prevenção de Ameaças</h4>
<ul class="list">
<li><strong>Gerenciamento de Tokens:</strong> Expiração automática e renovação segura para mitigar riscos de uso de tokens comprometidos.</li>
<li><strong>Proteção Contra SQL Injection:</strong> Uso de bibliotecas como <code>knex</code> para consultas parametrizadas.</li>
<li><strong>Sanitização de Entradas:</strong> Implementação de técnicas de sanitização para evitar injeções CRLF.</li>
<li><strong>Proteção Contra CSRF:</strong> Utilização de tokens de validação específicos para requisições críticas.</li>
</ul>
</div>

<div class="container">
<h3 class="section-title">Tecnologias e Frameworks Utilizados</h3>
<h4>Backend</h4>
<ul class="list">
<li><strong>Node.js:</strong> Plataforma principal de desenvolvimento.</li>
<li><strong>GraphQL:</strong> Eficiência no retorno de dados e maior flexibilidade.</li>
<li><strong>Knex.js:</strong> Query Builder para facilitar o uso do SQL.</li>
<li><strong>JWT:</strong> Autenticação robusta.</li>
</ul>

<h4>Frontend</h4>
<ul class="list">
<li><strong>Vue.js:</strong> Framework de front-end.</li>
<li><strong>Vuetify:</strong> Biblioteca para design responsivo.</li>
</ul>
</div>

<footer>
<p>&copy; 2024 João Luiz Silva Tavares</p>
</footer>

</body>
</html>
