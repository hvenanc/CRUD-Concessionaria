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
import br.edu.ifpe.recife.model.entities.Cliente;
import br.edu.ifpe.recife.model.repositories.ClienteRepository;


/**
 *
 * @author hvs1
 */
@WebServlet(name = "AtualizaClienteServlet", urlPatterns = {"/AtualizaClienteServlet"})
public class AtualizaClienteServlet extends HttpServlet {

 
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
        
        String c = request.getParameter("cpf");
        String atualiza = request.getParameter("Atualizar");
        Cliente p = ClienteRepository.read(c);
        
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
                
            out.println("<h1>Cliente Detalhado</h1>");
            out.println("<a href=\"index.html\"/><button class = \"botao4\">Voltar ao Menu Principal</button></a>");
            out.println("CPF: "+p.getCpf()+"</br>");
            out.println("Nome: "+p.getNome()+"</br>");
            out.println("Idade: "+p.getIdade()+"</br>");
            out.println("Telefone: "+p.getTelefone()+"</br>");
            out.println("Endereço: "+p.getEndereco()+"</br>");
            
                
            }
            
            else {
                out.println("<h1>Edite os dados do cliente </h1>");
                out.println("<a href=\"index.html\"/><button class = \"botao4\">Voltar ao Menu Principal</button></a>");
                
                
                out.println("<form method='post' action='AtualizaClienteServlet'>");
                
                out.println("CPF: <input type='hidden' name='cpf' value='"+p.getCpf()+"'>"+p.getCpf()+"</br>");
                out.println("Nome: <input type='text' name='nome' value='"+p.getNome()+"'></br>");
                out.println("Idade: <input type='text' name='idade' value='"+p.getIdade()+"'></br>");
                out.println("Telefone: <input type='text' name='telefone' value='"+p.getTelefone()+"'></br>");
                out.println("Endereço: <input type='text' name='endereco' value='"+p.getEndereco()+"'></br>");
                
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
        
        String cpf = request.getParameter("cpf");
        String nome = request.getParameter("nome");
        int idade = Integer.parseInt(request.getParameter("idade"));
        String telefone = request.getParameter("telefone");
        String endereco = request.getParameter("endereco");
        
        
        Cliente c = new Cliente();
        
        c.setCpf(cpf);
        c.setNome(nome);
        c.setIdade(idade);
        c.setTelefone(telefone);
        c.setEndereco(endereco);
        
        ClienteRepository.update(c);
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Cadastro de Clientes</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href =\"estilos.css\">");            
            out.println("</head>");
            out.println("<body>");
            
            //out.println("<h1>O Veículo foi atualizado com sucesso!</h1>");
            out.println("<h1>O Cliente "+nome+" foi atualizado com sucesso!</h1>");
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
