<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="top.jota.dao.main.entidades.services.UserServices"%>
<%@page import="top.jota.dao.main.entidades.Usuario"%>
<%@ page import="java.util.regex.Pattern" %>
<%@ page import="java.util.regex.Matcher" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Cadastrar Usuário e Senha</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">
    <link rel="stylesheet" type="text/css" href="css/styleTelaLoginCadastroSenha.css"/>
</head>
<body>
    <div class="container">
        <div class="card card-login mx-auto text-center bg-dark">
            <div class="card-header mx-auto bg-dark">
                <span> <img src="img/logo4.png" class="w-50" alt="Logo"> </span><br/>
                <span class="logo_title">Cadastrar Usuário e Senha</span>
            </div>
            <div class="card-body">
                <form action="cadastrouser" method="post">
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><i class="fas fa-user"></i></span>
                            </div>
                            <input type="text" name="nome" class="form-control" placeholder="Username">
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><i class="fas fa-key"></i></span>
                            </div>
                            <input type="password" name="senha" class="form-control" placeholder="Senha" id="senha">
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><i class="fas fa-key"></i></span>    
                            </div>
                            <input type="password" name="senha2" class="form-control" placeholder="Confirm Senha" id="senha2">
                        </div>
                    </div>
                  
                    <div class="mb-3 input-group-append d-flex justify-content-between align-items-center">
                       
                       <span class="text-primary mr-2 text-align-left"> 
                           <a href="telaLogin.jsp">Retornar ao Login </a>                           
                       </span>
                       
                       <span>
                        <span class="text-primary mr-1">   Mostrar Senhas   </span>
                        <input type="checkbox" onclick="mostrarSenha('senha', 'senha2')">
                        </span>
                    </div>

                    <div class="form-group">
                        <input type="submit" name="btn" value="Cadastrar" class="btn btn-outline-danger btn-block">
                    </div>
                </form>

                <p class="text-warning" align="left">
                    <% 
                        String msg = (String)request.getAttribute("msg");
                        if(msg == null) {
                            out.print("Jota Sistemas");
                        } else {
                            out.print(msg);
                        }
                    %>
                </p>
            </div>
        </div>
    </div>
    <script>
        function mostrarSenha(idCampoSenha, idCampoSenha2) {
            var senhaInput = document.getElementById(idCampoSenha);
            var senhaInput2 = document.getElementById(idCampoSenha2);
            if (senhaInput.type === "password" && senhaInput2.type === "password") {
                senhaInput.type = "text";
                senhaInput2.type = "text";
            } else {
                senhaInput.type = "password";
                senhaInput2.type = "password";
            }
        }
    </script>
</body>
</html>
