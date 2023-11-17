/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package top.jota.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import top.jota.dao.main.entidades.services.UserServices;

/**
 *
 * @author jotac
 */
@WebServlet(name = "deletarUser", urlPatterns = {"/deletarUser"})
public class deletarUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserServices userServices = new UserServices();        
        String id = request.getParameter("id_user");

        try {
            if (id != null) {
                // Verifique se o ID não é nulo antes de tentar excluir
                int userId = Integer.parseInt(id);
                userServices.deletar(userId);

                // Adicione uma mensagem de sucesso ou redirecione para a página de lista de usuários
                response.sendRedirect("listaUserServlet?msg=Usuário excluído com sucesso");
            } else {
                // Trate o caso em que o ID é nulo (pode ser um erro)
                response.sendRedirect("listaUserServlet?msg=Erro ao excluir usuário. ID não fornecido.");
            }
        } catch (IOException | NumberFormatException e) {
            // Trate a exceção aqui ou relance para o contêiner
            e.printStackTrace();
        }
    }
}
