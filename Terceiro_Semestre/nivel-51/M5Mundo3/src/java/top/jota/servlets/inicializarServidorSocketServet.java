/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package top.jota.servlets;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import top.jota.dao.servers.ServidorSocket;

@WebServlet(name = "inicializarServidorSocketServet", urlPatterns = {"/inicializarServidorSocketServet"}, loadOnStartup = 1)
public class inicializarServidorSocketServet extends HttpServlet {
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            new Thread (()-> {
            ServidorSocket servidorSocket = new ServidorSocket();        
        servidorSocket.start();

            }).start();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            new Thread(()->{
            ServidorSocket servidorSocket = new ServidorSocket();
            System.err.println("inicializarServidorSocketServeteeeeeeee");
            servidorSocket.start();
            
            }).start();
            }
}

