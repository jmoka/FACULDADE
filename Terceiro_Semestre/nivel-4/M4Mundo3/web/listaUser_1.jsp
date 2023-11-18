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
     <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.7/css/dataTables.bootstrap5.min.css"/>
    <link rel="stylesheet" href="https://cdn.datatables.net/responsive/2.5.0/css/responsive.bootstrap5.min.css"/>
    
</head>
<body> 
    <div class="container">
        <h2 class="mt-2 ">Lista de Usuários</h2>

        <c:if test="${not empty msg}">
            <div class="alert alert-info">${msg}</div>
        </c:if>

        <table id="example" class="table table-striped nowrap" style="width:100%">
            <thead>
                <tr>
                    <th>ID</th> 
                    <th>Nome</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${userList}">
                    <tr >
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td >
                             <a href="atualizarUserServlet?id_user=${user.id}" class="btn btn-primary px-2" onclick="return confirm('Tem certeza que deseja Atualizar?')">Atualizar</a>
                             <a href="deletarUserServlet?id_user=${user.id}" class="btn btn-danger px-2" onclick="return confirm('Tem certeza que deseja excluir?')">Excluir</a>

                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <a href="telaLogin.jsp" class="btn btn-primary px-2">Voltar</a>
    </div>

    
    
    
        
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <script src="https://cdn.datatables.net/1.13.7/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.13.7/js/dataTables.bootstrap5.min.js"></script>
    <script src="https://cdn.datatables.net/responsive/2.5.0/js/dataTables.responsive.min.js"></script>
    <script src="https://cdn.datatables.net/responsive/2.5.0/js/responsive.bootstrap5.min.js"></script>
    
    <link rel="stylesheet" type="text/css" href="css/styleListaUser1.css"/>
</body>
</html>

<script>
    
    new DataTable('#example', {
    responsive: true
    });
    
    
    function deletar(){
        
    }
    
</script>