/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package top.jota.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


// para passar varios 
 //@WebServlet(urlPatterns = {"/sa", "/no", "*.tf"})

@WebServlet("/userServlet")
public class UsuariosServlet1 extends HttpServlet {
   

  
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        

        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UsuariosServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Usnaso as anoteition " + request.getQueryString()+ request.getContextPath()+ "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                String nome = request.getParameter("nome");
        String senha = request.getParameter("senha");
        
        System.err.println(nome);
          
        System.err.println(senha);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String nome = request.getParameter("nome");
        String senha = request.getParameter("senha");
        
        System.err.println(nome);
          
        System.err.println(senha);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
