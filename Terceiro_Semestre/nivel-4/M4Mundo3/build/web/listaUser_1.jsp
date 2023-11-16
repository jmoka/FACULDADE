<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="top.jota.dao.main.entidades.services.UserServices" %>
<%@ page import="top.jota.dao.main.entidades.Usuario" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Lista de Usuários</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h2 class="mt-5">Lista de Usuários</h2>

        <c:if test="${not empty msg}">
            <div class="alert alert-info">${msg}</div>
        </c:if>

        <table class="table">
            <thead>
                <tr>
                    <th>ID</th> 
                    <th>Nome</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${userList}">
                    <tr class="success">
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>
                            <button class="btn btn-success">Atualizar</button>
                            <button class="btn btn-danger">Excluir</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <a href="telaLogin.jsp" class="btn btn-primary">Voltar</a>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="css/styleListaUser.css"/>
</body>
</html>
