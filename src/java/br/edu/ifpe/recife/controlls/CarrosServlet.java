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
 * @author Henri
 */
@WebServlet(name = "CarrosServlet", urlPatterns = {"/CarrosServlet"})
public class CarrosServlet extends HttpServlet {


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
       
        List <Carro> carros = CarroRepository.readAll();
        
         response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Carros Servlet</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href =\"estilos.css\">");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Veículos Cadastrados</h1>");
            out.println("<a href=\"index.html\"/><button class = \"botao4\">Voltar ao Menu Principal</button></a>");
            out.println("<table border=\"1\">");
            out.println("<tr><th>Codigo</th><th>Marca</th><th>Modelo</th><th>Ano de Fabricacao</th><th>Cor</th>"
                    + "<th>Operações</th></tr>");
            for(Carro c : carros){
                out.println("<tr>"
                        + "<td>"+c.getCodigo()+"</td>"
                        + "<td>"+c.getMarca()+"</td>"
                        + "<td>"+c.getNome()+"</td>"
                        + "<td>"+c.getAnoFab()+"</td>"
                        + "<td>"+c.getCor()+"</td>"
                        + "<td><a href='VisualizarCarroServlet?codigo="+c.getCodigo()+"'>"
                                + "<button class = \"visu\">Visualizar</button> </a> "
                                + "<a href = 'AtualizaCarroServlet?"
                                + "codigo="+c.getCodigo()+"&Atualizar=sim'><button class = \"at\">Atualizar</button> </a>"
                                        + "<a href = 'DeletarCarroServlet?codigo="+c.getCodigo()+"'><button class = \"del\">Deletar</button> </a></td></tr>");
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
        
        String codigo = request.getParameter("codigo");
        String nome = request.getParameter("nome");
        String marca = request.getParameter("marca");
        int anoFab = Integer.parseInt(request.getParameter("anoFab"));
        String cor = request.getParameter("cor");
        
        
        Carro c = new Carro();
        
        c.setCodigo(codigo);
        c.setNome(nome);
        c.setMarca(marca);
        c.setAnoFab(anoFab);
        c.setCor(cor);
        
        CarroRepository.insert(c);
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Cadastro de Veículos</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href =\"estilos.css\">");             
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1>O Veículo "+marca+" "+nome+" foi cadastrado com sucesso!</h1>");
            out.println("<a href=\"index.html\"/><button class = \"botao4\">Voltar ao Menu Principal</button></a>");
            
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
