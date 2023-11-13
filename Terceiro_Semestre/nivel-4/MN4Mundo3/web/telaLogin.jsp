    <%-- 
    Document   : index
    Created on : 7 de nov. de 2023, 14:51:36
    Author     : jotac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="top.jota.dao.main.entidades.services.UserServices"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>JSP Page</title>

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
                <span> <img src="img/logo4.png" class="img-fluid w-50" alt="Logo"> </span><br/>
                <span class="logo_title mt-3">Login</span>
            </div>
            <div class="card-body">
                <form action="telaLoginServlet" method="post">
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
                            <input type="password" name="senha" class="form-control" placeholder="Password">
                        </div>
                    </div>

                    <div class="form-group">                        
                        <input type="submit" name="btn" value="Login" class="btn btn-outline-danger btn-block login_btn">
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

            <div >
                <div class="text-right">
                    <a href="cadastrarUsuarioSenha.jsp">Cadastrar</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
