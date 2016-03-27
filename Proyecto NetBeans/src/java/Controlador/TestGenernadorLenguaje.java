/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Tester;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jose
 */
@WebServlet(name = "TestGenernadorLenguaje", urlPatterns = {"/TestGenernadorLenguaje"})
public class TestGenernadorLenguaje extends HttpServlet {

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
        Tester tester = armarTesterDesdeSolicitud(request);
        
        int[] tablaFrecuencias = tester.generarTablaFrecuenciasLenguaje();
        request.setAttribute("tablaFrecuencias", tablaFrecuencias);
        
        request.getRequestDispatcher("mostrarB.jsp").forward(request, response);
    }
    
    private Tester armarTesterDesdeSolicitud (HttpServletRequest request){
        //tomo los atributos de request y se los asigno al modelo
        int cantidadIntervalos = Integer.parseInt(request.getParameter("cantidadIntervalos"));
        int cantidadNumeros = Integer.parseInt(request.getParameter("cantidadNumeros"));
        
        //valido los datos que sean correctos, EN realidad se hace con javascript del lado del cliente
        if (cantidadIntervalos == 0 || cantidadNumeros == 0) {
            request.getRequestDispatcher("error.jsp");
            return null;
        }
        return new Tester(cantidadIntervalos, cantidadNumeros);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
