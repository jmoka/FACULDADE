package top.jota.servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
                    request.setAttribute("msg", "Lista de usuario nulo");
                    
                }else{
                    request.setAttribute("userList", userList);
                    System.out.println("Numero de usuurios: " + userList.size());
                    request.getRequestDispatcher("/listaUser.jsp")
                    .forward(request, response);
                
                }           
            } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
