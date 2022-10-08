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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Henri
 */
@WebServlet(name = "ClientesServlet", urlPatterns = {"/ClientesServlet"})
public class ClientesServlet extends HttpServlet {


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
       
        List <Cliente> clientes = ClienteRepository.readAll();
        
         response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Clientes Servlet</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href =\"estilos.css\">");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Clientes Cadastrados</h1>");
            out.println("<a href=\"index.html\"/><button class = \"botao4\">Voltar ao Menu Principal</button></a>");
            out.println("<table border=\"1\">");
            out.println("<tr><th>CPF</th><th>Nome</th><th>Idade</th><th>Telefone</th><th>Cor</th>"
                    + "<th>Operações</th></tr>");
            for(Cliente c : clientes){
                out.println("<tr>"
                        + "<td>"+c.getCpf()+"</td>"
                        + "<td>"+c.getNome()+"</td>"
                        + "<td>"+c.getIdade()+"</td>"
                        + "<td>"+c.getTelefone()+"</td>"
                        + "<td>"+c.getEndereco()+"</td>"
                        + "<td><a href='VisualizarClienteServlet?cpf="+c.getCpf()+"'>"
                                + "<button class = \"visu\">Visualizar</button> </a> "
                                + "<a href = 'AtualizaClienteServlet?"
                                + "cpf="+c.getCpf()+"&Atualizar=sim'><button class = \"at\">Atualizar</button> </a>"
                                        + "<a href = 'DeletarClienteServlet?cpf="+c.getCpf()+"'><button class = \"del\">Deletar</button> </a></td></tr>");
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
        
        ClienteRepository.insert(c);
        
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
            
            out.println("<h1>O Cliente "+nome+" foi cadastrado com sucesso!</h1>");
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
