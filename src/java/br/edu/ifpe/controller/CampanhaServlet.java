/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.controller;

import br.edu.ifpe.model.negocio.Campanha;
import br.edu.ifpe.model.repositorio.RepositorioCampanha;
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
@WebServlet(name = "CampanhaServlet", urlPatterns = {"/CampanhaServlet"})
public class CampanhaServlet extends HttpServlet {

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
            out.println("<title>Listar campanhas</title>");
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
        String codigo = request.getParameter("codigo");

        if (codigo != null) {
            Campanha campanha = RepositorioCampanha.read(Integer.parseInt(codigo));
            String operacao = request.getParameter("operacao");

            if (operacao != null && operacao.equals("edit")) {
                response.setContentType("text/html;charset=UTF-8");
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
                    out.println("<h1>Editar Campanha: " + campanha.getCodigo() + "</h1>");
                    out.println("<form method='post' action='CampanhasServlet'>");
                    out.println("<input type='hidden' name='codigo' value='" + campanha.getCodigo() + "'/><br>");
                    out.println("Data de Início: <input type='text' name='dataInicio' value='" + campanha.getDataInicio() + "'/><br>");
                    out.println("Data de Fim: <input type='text' name='dataFim' value='" + campanha.getDataFim() + "'/><br>");
                    out.println("Objetivo: <input type='text' name='objetivo' value='" + campanha.getObjetivo() + "'/><br>");
                    out.println("Descrição: <input type='text' name='descricao' value='" + campanha.getDescricao() + "'/><br>");
                    out.println("<a class='btn btn-danger' href='CampanhaServlet'>Voltar</a>");
                    out.println("<input class='btn btn-success' type='submit' value='Editar'/>");
                    out.println("</form>");
                    out.println("</body>");
                    out.println("</html>");
                    return;
                }
            } else if (operacao != null && operacao.equals("delete")) {
                RepositorioCampanha.delete(campanha);
                response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Campanha Deletada</title>");
                    out.println("<meta charset='utf-8'>");
                    out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
                    out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>");
                    out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>");
                    out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js'></script>");
                    out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js'></script>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Campanha Deletada com Sucesso!</h1>");
                    out.println("<a href='CampanhaServlet'>Voltar</a>");
                    out.println("</body>");
                    out.println("</html>");
                }
            } else {
                response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Detalhes da Campanha</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Detalhes da Campanha: " + campanha.getCodigo() + "</h1>");
                    out.println("<h5>Data de Início: " + campanha.getDataInicio() + "</h5>");
                    out.println("<h5>Data de Fim: " + campanha.getDataFim() + "</h5>");
                    out.println("<h5>Objetivo: " + campanha.getObjetivo() + "</h5>");
                    out.println("<h5>Descrição: " + campanha.getDescricao() + "</h5>");
                    out.println("<a href='CampanhaServlet'>Voltar</a>");
                    out.println("</body>");
                    out.println("</html>");
                    return;
                }
            }
        }

        List<Campanha> campanhas = RepositorioCampanha.readAll();

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Campanhas Cadastradas</title>");
            out.println("<meta charset='utf-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
            out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>");
            out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>");
            out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js'></script>");
            out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js'></script>");
            out.println("</head>");
            out.println("<body class='text-center'>");

            out.println("<h1>Campanhas Cadastradas</h1>");

            out.println("<div class='container'>");
            out.println("<div class='btn-group' role='group' >");
            out.println("<a href='index.html' class='btn btn-primary mb-4' style='margin-right: 10px;'>Home</a>");
            out.println("<a href='CadastrarCampanhas.html' class='btn btn-success mb-4'>Cadastrar Campanha</a>");
            out.println("</div>");
            out.println("</div>");

            out.println("<table class='table table-bordered'>");
            out.println("<tr><th>Código</th><th>Data de Início</th><th>Data de Fim</th><th>Objetivo</th><th>Descrição</th><th>Ações</th></tr>");

            for (Campanha campanha : campanhas) {
                out.println("<tr>");
                out.println("<td>" + campanha.getCodigo() + "</td>");
                out.println("<td>" + campanha.getDataInicio() + "</td>");
                out.println("<td>" + campanha.getDataFim() + "</td>");
                out.println("<td>" + campanha.getObjetivo() + "</td>");
                out.println("<td>" + campanha.getDescricao() + "</td>");
                out.println("<td>" + "<div class='btn-group' role='group'>"
                        + "<a class='btn btn-primary' href='CampanhaServlet?codigo=" + campanha.getCodigo() + "'>Detalhar</a> "
                        + "<a class='btn btn-success' href='CampanhaServlet?codigo=" + campanha.getCodigo() + "&operacao=edit'>Editar</a>"
                        + "<a class='btn btn-danger' href='CampanhaServlet?codigo=" + campanha.getCodigo() + "&operacao=delete'>Deletar</a>"
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
        
        //RESGATANDO DADOS
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        String objetivo = request.getParameter("objetivo");
        String descricao = request.getParameter("descricao");
        String  dataInicio =  request.getParameter("dataInicio");
        String dataFim =  request.getParameter("dataFim");
        
        //INSERINDO DADOS
        Campanha campanha = new Campanha();
        
        campanha.setCodigo(codigo);
        campanha.setDataInicio(dataInicio);
        campanha.setDataFim(dataFim);
        campanha.setObjetivo(objetivo);
        campanha.setDescricao(descricao);
         
//        RepositorioCampanha.update(campanha);
        RepositorioCampanha.update(campanha);

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use the following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>listar campanhas</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Campanha Atualizada com Sucesso!</h1>");
            out.println("<a href='CampanhaServlet'>Voltar</a>");  
            out.println("</body>");
            out.println("</html>");
        }

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
