/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Generador;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jose
 */
@WebServlet(name = "ContinuarSerie", urlPatterns = {"/ContinuarSerie"})
public class ContinuarSerie extends HttpServlet {

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
        HttpSession session = request.getSession(true);
        //creo el modelo a partir de la session del usuraio
        Generador generador = (Generador) session.getAttribute("generador");
        
        int factorMultiplicativo = (Integer) session.getAttribute("factorMultiplicativo");
        float numerosAnteriores[] = (float[]) session.getAttribute("numerosGenerados");
        
        float numeros[] = new float[numerosAnteriores.length + 1];
        
        System.arraycopy(numerosAnteriores, 0, numeros, 0, numeros.length - 1);
              
        numeros[numeros.length -1 ] = generador.nextRandom() * factorMultiplicativo;
        
        
        //una vez generados los numeros aleatorios, lo envio al jsp para los muestre
        //en este caso lo asemos a nivel de sesion para que este accecible en toda la sesion de usuario,
        //cosa que nos permite compartir informacion.  Terminada la session, se destruye.
        session.setAttribute("numerosGenerados", numeros);
        //el generador no cambia, sino que asigno un nuevo set de numero generados 
//session.setAttribute("generador", generador);
       
        //como cuando agrego va adepender de que boton aprete, paso el valor del factor en el request
        request.getRequestDispatcher("mostrarA.jsp").forward(request, response);
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
