/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.controller;

import br.edu.ifpe.model.negocio.Adm;
import br.edu.ifpe.model.repositorio.RepositorioAdm;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Well
 */
@WebServlet(name = "AdmServlet", urlPatterns = {"/AdmServlet"})
public class AdmServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Listar Adm</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");

        if (login != null) {
            Adm adm = RepositorioAdm.read(request.getParameter("login"));
            String operacao = request.getParameter("operacao");

            if (operacao != null && operacao.equals("edit")) {
                try (PrintWriter out = response.getWriter()) {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Editar Campanha</title>");
                    out.println("<meta charset='utf-8'>");
                    out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
                    out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>");
                    out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>");
                    out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js'></script>");
                    out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js'></script>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Editar Adm: " + adm.getLogin() + "</h1>");
                    out.println("<form method='post' action='AdmServlet'>");
                    out.println("<input type='hidden' name='login' value='" + adm.getLogin() + "'/><br>");
                    out.println("Senha: <input type='text' name='senha' value='" + adm.getSenha() + "'/><br>");
                    out.println("<a class='btn btn-danger' href='AdmServlet'>Voltar</a>");
                    out.println("<input class='btn btn-success' type='submit' value='Editar'/>");
                    out.println("</form>");
                    out.println("</body>");
                    out.println("</html>");
                    return;
                }
            }
        }

        List<Adm> adm = RepositorioAdm.readAll();

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Adm Cadastradas</title>");
            out.println("<meta charset='utf-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
            out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>");
            out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>");
            out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js'></script>");
            out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js'></script>");
            out.println("</head>");
            out.println("<body class='text-center'>");

            out.println("<h1>Adms Cadastrados</h1>");

            out.println("<div class='container'>");
            out.println("<div class='btn-group' role='group' >");
            out.println("<a href='index.html' class='btn btn-primary mb-4' style='margin-right: 10px;'>Home</a>");
            out.println("<a href='CadastrarAdm.html' class='btn btn-success mb-4'>Cadastrar ADM</a>");
            out.println("</div>");
            out.println("</div>");

            out.println("<table class='table table-bordered'>");
            out.println("<tr><th>Login</th><th>Senha</th><th>Ações</th></tr>");

            for (Adm adms : adm) {
                out.println("<tr>");
                out.println("<td>" + adms.getLogin() + "</td>");
                out.println("<td>" + adms.getSenha() + "</td>");
                out.println("<td>" + "<div class='btn-group' role='group'>"
                        + "<a class='btn btn-primary' href='CampanhaServlet?codigo=" + adms.getLogin() + "'>Detalhar</a> "
                        + "<a class='btn btn-success' href='CampanhaServlet?codigo=" + adms.getLogin() + "&operacao=edit'>Editar</a>"
                        + "<a class='btn btn-danger' href='CampanhaServlet?codigo=" + adms.getLogin() + "&operacao=delete'>Deletar</a>"
                        + "</div>" + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
