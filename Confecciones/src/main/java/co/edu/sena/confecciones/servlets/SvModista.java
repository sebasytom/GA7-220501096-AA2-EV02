/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package co.edu.sena.confecciones.servlets;

import co.edu.sena.confecciones.logica.Modista;
import co.edu.sena.confecciones.logica.Controladora;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SEBAS
 */

@WebServlet(name = "SvModista", urlPatterns = {"/SvModista"})
public class SvModista extends HttpServlet {
    
Controladora controladora = new Controladora();

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
        
        List<Modista> modistas = new ArrayList<>();
        
        modistas = controladora.listarModistas();
              
                   
        HttpSession sesion=request.getSession();
        sesion.setAttribute("listaModistas", modistas);
        
        response.sendRedirect("listar.jsp");     
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
        
        
        int id= Integer.parseInt(request.getParameter("id"));
        String nombre= request.getParameter("nombre");
        String apellido=request.getParameter("apellido");
        int telefono= Integer.parseInt(request.getParameter("telefono"));
        
    
      Modista m = new Modista();
      
      m.setId(id);
      m.setNombre(nombre);
      m.setApellido(apellido);
      m.setTelefono(telefono);
      
      controladora.registrarModista(m);
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
