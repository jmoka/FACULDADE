<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Projeto de Desenvolvimento Full Stack</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/vuetify@2.6.15/dist/vuetify.min.css">
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700,900" rel="stylesheet">
</head>
<body>
    <div id="app">
        <!-- Navbar -->
        <v-app>
            <v-app-bar app dense color="blue darken-2" dark>
                <v-toolbar-title>Projeto Full Stack</v-toolbar-title>
                <v-spacer></v-spacer>
                <v-btn text href="#querys">Queries</v-btn>
                <v-btn text href="#mutations">Mutations</v-btn>
            </v-app-bar>

            <!-- Carrossel de Imagens -->
            <v-container class="my-5">
                <v-carousel cycle hide-delimiters>
                    <v-carousel-item v-for="(tech, index) in tecnologias" :key="index">
                        <v-img :src="tech.imagem" height="200px"></v-img>
                    </v-carousel-item>
                </v-carousel>
            </v-container>

            <!-- Apresentação -->
            <v-container>
                <v-row>
                    <v-col cols="12" md="6">
                        <v-img src="sua-imagem.jpg" height="200px"></v-img>
                    </v-col>
                    <v-col cols="12" md="6">
                        <h1>João Luiz Silva Tavares</h1>
                        <p>Durante dois anos de estudo na Faculdade Estácio de Sá, desenvolvi habilidades que me permitem criar sistemas seguros, com foco na proteção de dados e no controle de acesso robusto.</p>
                    </v-col>
                </v-row>
            </v-container>

            <!-- Seções de Queries e Mutations -->
            <v-container id="querys">
                <h2>Querys</h2>
                <pre><code>query { usuarios { id, nome, email, perfil { nome, rotulo }, status, dataCriacao } }</code></pre>
                <pre><code>query { usuarioID(id:1) { id, nome, email, status, perfil { id, nome, rotulo }, dataCriacao } }</code></pre>
            </v-container>

            <v-container id="mutations">
                <h2>Mutations</h2>
                <pre><code>mutation { loginUsuario(dados: { email: "master@jotaempresa.com", senha: "Master@123" }) { id, nome, email, status, perfil { nome, rotulo } } }</code></pre>
                <pre><code>mutation { novoUsuario(user: { nome: "dev", email: "dev41@dev.com", senha: "123", perfil: 4, status: "ATIVO" }) { id, nome, email, perfil { nome, rotulo }, status } }</code></pre>
                <pre><code>mutation { alterarUsuario(user: { nome: "brasil2", email: "dev1000@dev.com", status: "ATIVO", perfil: 3 }, filtro: { id: 42 }) { id, nome, email, status, perfil { id, nome, rotulo } } }</code></pre>
                <pre><code>mutation { excluirUsuario(filtro: { id: 2 }) { nome, id, email, status, dataCriacao, perfil { nome, rotulo } } }</code></pre>
            </v-container>

            <!-- Informações do Projeto -->
            <v-container class="mt-5">
                <h2>Projeto de Desenvolvimento Full Stack - Nível 5: Software Sem Segurança Não Serve</h2>
                <p><strong>Faculdade Estácio de Sá</strong><br>
                <strong>Curso:</strong> Desenvolvimento Full Stack<br>
                <strong>Aluno:</strong> João Luiz Silva Tavares</p>
                <p>Durante dois anos de estudo nesta instituição respeitada, desenvolvi diversas habilidades que me capacitaram a apresentar este trabalho com confiança. A atividade tem como objetivo demonstrar a criação de um sistema que implementa um alto grau de segurança, com ênfase na proteção de dados sensíveis, controle de acesso robusto e práticas de desenvolvimento seguro.</p>
            </v-container>

            <v-container class="mt-5">
                <h3>Objetivos Técnicos da Prática</h3>
                <h4>Controle Básico de Acesso a uma API REST</h4>
                <p>A implementação foi projetada com um sistema de autenticação baseado em tokens (JWT). Esse mecanismo garante que somente usuários autorizados possam acessar recursos protegidos da API, minimizando riscos de acesso não autorizado.</p>

                <h4>Tratamento de Dados Sensíveis e Log de Erros</h4>
                <ul>
                    <li><strong>Proteção de Senhas:</strong> Utilização de algoritmos de hashing, como <code>bcrypt</code>.</li>
                    <li><strong>Log de Erros Seguros:</strong> Configuração para não exibir informações detalhadas que possam ser exploradas por atacantes.</li>
                </ul>

                <h4>Prevenção de Ameaças</h4>
                <ul>
                    <li><strong>Gerenciamento de Tokens:</strong> Expiração automática e renovação segura para mitigar riscos de uso de tokens comprometidos.</li>
                    <li><strong>Proteção Contra SQL Injection:</strong> Uso de bibliotecas como <code>knex</code> para consultas parametrizadas.</li>
                    <li><strong>Sanitização de Entradas:</strong> Implementação de técnicas de sanitização para evitar injeções CRLF.</li>
                    <li><strong>Proteção Contra CSRF:</strong> Utilização de tokens de validação específicos para requisições críticas.</li>
                </ul>
            </v-container>

            <v-container class="mt-5">
                <h3>Tecnologias e Frameworks Utilizados</h3>
                <h4>Backend</h4>
                <ul>
                    <li><strong>Node.js:</strong> Plataforma principal de desenvolvimento.</li>
                    <li><strong>GraphQL:</strong> Eficiência no retorno de dados e maior controle sobre as respostas.</li>
                    <li><strong>Apollo Server:</strong> Gerenciamento seguro de consultas GraphQL.</li>
                    <li><strong>Bibliotecas de Segurança:</strong> <code>jsonwebtoken</code>, <code>dotenv</code>.</li>
                    <li><strong>Outras Dependências:</strong> <code>axios</code>, <code>bcrypt</code>, <code>mysql</code>, <code>knex</code>.</li>
                </ul>

                <h4>Frontend</h4>
                <ul>
                    <li><strong>Vue.js:</strong> Framework para interfaces interativas.</li>
                    <li><strong>Vuetify:</strong> Framework de componentes para interfaces responsivas e seguras.</li>
                    <li><strong>Vuex:</strong> Gerenciamento eficiente de estado.</li>
                    <li><strong>Apollo Client:</strong> Integração com GraphQL.</li>
                    <li><strong>Core-js:</strong> Compatibilidade com diferentes navegadores.</li>
                </ul>
            </v-container>

            <v-container class="mt-5">
                <h3>Passos para a Implementação</h3>
                <ol>
                    <li><strong>Instalação das Dependências:</strong> <code>npm install</code></li>
                    <li><strong>Configuração de Variáveis de Ambiente:</strong> Configure as variáveis de ambiente em um arquivo <code>.env</code>.</li>
                    <li><strong>Instale o SQL em sua máquina:</strong> Utilize os dados de conexão fornecidos.</li>
                    <li><strong>Execução do Projeto:</strong>
                        <ul>
                            <li><strong>Para iniciar o servidor de desenvolvimento:</strong> <code>npm start</code></li>
                            <li><strong>Feche a aplicação:</strong> <code>ctrl+c</code> e <code>s + enter</code></li>
                            <li><strong>Executar as Migrations:</strong> <code>knex migrate:latest</code></li>
                            <li><strong>Executar as Seeds:</strong> <code>knex seed:run</code></li>
                            <li><strong>Execute o sistema:</strong> <code>npm start</code></li>
                        </ul>
                    </li>
                </ol>
            </v-container>

            <v-container class="mt-5">
                <h3>Dependências e DevDependencies</h3>
                <pre><code>

{
"name": "backend",
"version": "1.0.0",
"description": "Missão Pratica nivel 5 mundo 5",
"main": "index.js",
"type": "module",
"scripts": {
"start": "nodemon src/index.js",
"client": "node client.js",
"dev": "nodemon --watch client.js"
},
"dependencies": {
"apollo-server-express": "^3.9.0",
"bcrypt": "^5.0.1",
"dotenv": "^16.3.1",
"express": "^4.18.2",
"graphql": "^15.6.0",
"jsonwebtoken": "^8.5.1",
"knex": "^2.0.0",
"mysql": "^2.18.1"
},
"devDependencies": {
"nodemon": "^2.0.22"
}
}
</code></pre>
</v-container>
</v-app>
</div>

    <script src="https://cdn.jsdelivr.net/npm/vue@2.6.14/dist/vue.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/vuetify@2.6.15/dist/vuetify.min.js"></script>
    <script>
        new Vue({
            el: '#app',
            vuetify: new Vuetify(),
            data: {
                tecnologias: [
                    { imagem: 'path/to/image1.jpg' },
                    { imagem: 'path/to/image2.jpg' },
                    { imagem: 'path/to/image3.jpg' }
                ]
            }
        });
    </script>

</body>
</html>
