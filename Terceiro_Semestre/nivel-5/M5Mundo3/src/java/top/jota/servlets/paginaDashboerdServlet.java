package top.jota.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import top.jota.dao.servers.ClaintServerSocket;

@WebServlet(name = "paginaDashboerdServlet", urlPatterns = {"/paginaDashboerdServlet"})
public class paginaDashboerdServlet extends HttpServlet {

    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
            ClaintServerSocket claintServerSocket = new ClaintServerSocket();
            String msg = claintServerSocket.start();
            request.setAttribute("msg", msg);
            System.err.println("msg " + msg);
            RequestDispatcher dispatcher = request.getRequestDispatcher("dashboerd.jsp");
            dispatcher.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
