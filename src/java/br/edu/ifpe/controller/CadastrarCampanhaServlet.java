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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Well
 */
@WebServlet(name = "CadastrarCampanhaServlet", urlPatterns = {"/CadastrarCampanhaServlet"})
public class CadastrarCampanhaServlet extends HttpServlet {

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
        
        RepositorioCampanha.create(campanha);

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Campanha cadastrada</title>");
            out.println("<meta charset='utf-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
            out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>");
            out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>");
            out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js'></script>");
            out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js'></script>");
            out.println("</head>");
            out.println("<body class='text-center'>");

            out.println("<div class='mt-4'>");
            
            out.println("<h1>Temos uma nova campanha cadastrada Cód.: " + codigo + "</h1>");

            out.println("</div>");

            out.println("<div class='mb-6'>");
            out.println("<div class='col-sm-12'>");
            out.println("<a href='index.html' class='btn btn-primary mt-4'>Home</a>");
            out.println("<a href='CadastrarCampanhas.html' class='btn btn-success mt-4'>Cadastrar Campanha</a>");                       
            out.println("</div>");
            out.println("<a href='CampanhaServlet' class='btn btn-primary mt-4'>Listar Campanhas</a>");
            out.println("</div>");
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
