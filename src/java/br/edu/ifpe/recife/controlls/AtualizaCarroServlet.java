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


/**
 *
 * @author hvs1
 */
@WebServlet(name = "AtualizaCarroServlet", urlPatterns = {"/AtualizaCarroServlet"})
public class AtualizaCarroServlet extends HttpServlet {

 
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
        String atualiza = request.getParameter("Atualizar");
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
            
            
            if (atualiza == null) {
                
            out.println("<h1>Veículo Detalhado</h1>");
            out.println("<a href=\"index.html\"/><button class = \"botao4\">Voltar ao Menu Principal</button></a>");
            out.println("Código: "+p.getCodigo()+"</br>");
            out.println("Marca: "+p.getMarca()+"</br>");
            out.println("Modelo: "+p.getNome()+"</br>");
            out.println("Ano Fabricação: "+p.getAnoFab()+"</br>");
            out.println("Cor: "+p.getCor()+"</br>");
            
                
            }
            
            else {
                out.println("<h1>Edite o Veículo </h1>");
                out.println("<a href=\"index.html\"/><button class = \"botao4\">Voltar ao Menu Principal</button></a>");
                
                
                out.println("<form method='post' action='AtualizaCarroServlet'>");
                
                out.println("Código: <input type='hidden' name='codigo' value='"+p.getCodigo()+"'>"+p.getCodigo()+"</br>");
                out.println("Nome: <input type='text' name='nome' value='"+p.getNome()+"'></br>");
                out.println("Marca: <input type='text' name='marca' value='"+p.getMarca()+"'></br>");
                out.println("Ano de Fabricação: <input type='text' name='anoFab' value='"+p.getAnoFab()+"'></br>");
                out.println("Cor: <input type='text' name='cor' value='"+p.getCor()+"'></br>");
                
                out.println("<button type = \"submit\" class = \"botao5\" value='Atualizar'> Cadastrar </button>");
                
                out.println("</form>");
            }
            
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
        
        CarroRepository.update(c);
        
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
            
            //out.println("<h1>O Veículo foi atualizado com sucesso!</h1>");
            out.println("<h1>O Veículo "+marca+" "+nome+" foi atualizado com sucesso!</h1>");
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
