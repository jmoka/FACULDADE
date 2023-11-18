package top.jota.servlets;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import top.jota.dao.main.entidades.Usuario;
import top.jota.dao.main.entidades.services.UserServices;

@WebServlet(name = "atualizarUserServlet", urlPatterns = {"/atualizarUserServlet"})
public class atualizarUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserServices userServices = new UserServices();
        String id = request.getParameter("id_user");

        try {
            if (id != null) {
                int userId = Integer.parseInt(id);

                Usuario usuarioRecuperado = userServices.buscarId(userId);

                String nome = usuarioRecuperado.getName();
                String senha = usuarioRecuperado.getSenha();

                request.setAttribute("id", userId);
                request.setAttribute("nome", nome);
                request.setAttribute("senha", senha);

                request.getRequestDispatcher("/atualizarUsuario.jsp").forward(request, response);

            } else {
                response.sendRedirect("listaUserServlet?msg=Erro ao atualizar usuário. ID não fornecido.");
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                       
                        UserServices userServices = new UserServices();
                        
                        String id_user = request.getParameter("id_user");
                        String nome = request.getParameter("nome");
                        String senha = request.getParameter("senha");
                        String senha2 = request.getParameter("senha2");
                        
                        int userId = Integer.parseInt(id_user);
                        Usuario usuarioRecuperado = userServices.buscarId(userId);
                        
                        if (usuarioRecuperado != null) {
                            usuarioRecuperado.setName(nome);
                            usuarioRecuperado.setSenha(senha);
                        } else {
                            System.err.println("ERRO");                    }
                        
                        
                        
                        String regex = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()\\-_=+{};:,<.>]).{4,}$";
                   
                        if (senha != null && !senha.isEmpty() && senha.equals(senha2) && nome != null && !nome.isEmpty()) {
                            try {
                                Pattern pattern = Pattern.compile(regex);
                                Matcher matcher = pattern.matcher(senha);

                                if (matcher.matches()) {
                                    Usuario atualizado = userServices.atualizar(usuarioRecuperado);

                                    if (atualizado != null) {
                                       request.setAttribute("msg", "Cadastro Efetuado com Sucesso!<br>");
                                       response.sendRedirect("listaUserServlet");

                                    } else {
                                       request.setAttribute("msg","Erro no Cadastro. Tente Novamente.");
                                    }
                                } else {
                                  request.setAttribute("msg", "Formato Senha Inválida!<br>" +
                                                                    "=> Mínimo 4 Caracteres<br>" +
                                                                    "=> Um número<br>" +
                                                                    "=> Um Símbolo<br>" +
                                                                    "=> Uma Letra Maiúscula");

                                }
                            } catch (Exception e) {
                                request.setAttribute("msg","Senha já Cadastrada");
                                RequestDispatcher dispatcher = request.getRequestDispatcher("atualizarUsuario.jsp");
                        dispatcher.forward(request, response);
                            }
                        } else if (nome == null && senha == null && senha2 == null) {
                            request.setAttribute("msg","Todos os Campos Vazios");
                            RequestDispatcher dispatcher = request.getRequestDispatcher("atualizarUsuario.jsp");
                        dispatcher.forward(request, response);
                        } else if (nome == null || nome.isEmpty()) {
                            request.setAttribute("msg","Campo nome vazio");
                            RequestDispatcher dispatcher = request.getRequestDispatcher("atualizarUsuario.jsp");
                        dispatcher.forward(request, response);
                        } else if (senha == null || senha.isEmpty()) {
                            request.setAttribute("msg","Campo senha vazio");
                            RequestDispatcher dispatcher = request.getRequestDispatcher("atualizarUsuario.jsp");
                        dispatcher.forward(request, response);
                        } else if (senha2 == null || senha2.isEmpty()) {
                           request.setAttribute("msg","Campo Confirmar senha está vazio");
                           RequestDispatcher dispatcher = request.getRequestDispatcher("atualizarUsuario.jsp");
                        dispatcher.forward(request, response);
                        } else {
                           request.setAttribute("msg","Senha não Confere");
                           RequestDispatcher dispatcher = request.getRequestDispatcher("atualizarUsuario.jsp");
                        dispatcher.forward(request, response);
                        }
                      
                        
    }   

}
