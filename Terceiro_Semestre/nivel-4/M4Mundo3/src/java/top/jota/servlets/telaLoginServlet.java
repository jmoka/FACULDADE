/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package top.jota.servlets;

import javax.servlet.RequestDispatcher;
import java.io.IOException;
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
@WebServlet(name = "telaLoginServlet", urlPatterns = {"/telaLoginServlet"})
public class telaLoginServlet extends HttpServlet {

       
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
           String nome = request.getParameter("nome");
           String senha = request.getParameter("senha");
           
           UserServices userservices = new UserServices();
           String aut = userservices.autenticarUsuario(nome, senha);

                 if (aut != null) {
                        response.sendRedirect("dashboerd.html");
                } else {
                        String msg = null;

                        if (nome == null || nome.isEmpty()) {
                                msg = "Nome está vazio";
                        } else if (senha == null || senha.isEmpty()) {
                                msg = "Senha está vazia";
                        } else {
                                msg = "Usuário ou Senha não Encontrados";
                        }

                    request.setAttribute("msg", msg);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("telaLogin.jsp");
                    dispatcher.forward(request, response);
                } 
    
                
    }

   

}
