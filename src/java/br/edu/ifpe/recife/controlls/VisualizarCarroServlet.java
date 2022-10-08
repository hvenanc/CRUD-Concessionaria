/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controlls;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.edu.ifpe.recife.model.entities.Carro;
import br.edu.ifpe.recife.model.repositories.CarroRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hvs1
 */
@WebServlet(name = "VisualizarCarroServlet", urlPatterns = {"/VisualizarCarroServlet"})
public class VisualizarCarroServlet extends HttpServlet {

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
        
        String c = request.getParameter("codigo");
        Carro p = CarroRepository.read(c);
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Detalhar</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href =\"estilos.css\">");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Veículo Detalhado</h1>");
            out.println("<a href=\"index.html\"/><button class = \"botao4\">Voltar ao Menu Principal</button></a>");
            out.println("</br>");
            out.println("</br>");
            out.println("</br>");
            out.println("</br>");
            out.println("Código: "+p.getCodigo()+"</br>");
            out.println("Marca: "+p.getMarca()+"</br>");
            out.println("Modelo: "+p.getNome()+"</br>");
            out.println("Ano Fabricação: "+p.getAnoFab()+"</br>");
            out.println("Cor: "+p.getCor()+"</br>");
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
