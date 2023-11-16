package top.jota.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import top.jota.dao.main.entidades.Usuario;
import top.jota.dao.main.entidades.services.UserServices;

@WebServlet(name = "listaUserServlet", urlPatterns = {"/listaUserServlet"})
public class listaUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            UserServices userServices = new UserServices();
            List<Usuario> userList = userServices.findAllUser();
            
            if (userList == null) {
                request.setAttribute("msg", "Lista de usuários nula");
            } else {
                request.setAttribute("userList", userList);
                System.out.println("Número de usuários: " + userList.size());
            }
            
            request.getRequestDispatcher("/listaUser_1.jsp").forward(request, response);
                    
        } catch (Exception e) {
            System.out.println(e.getMessage());
            request.setAttribute("msg", "Erro: " + e.getMessage());
            request.getRequestDispatcher("errorPage.jsp").forward(request, response);
        }
    }
}
