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
@WebServlet(name = "generarNumeros", urlPatterns = {"/generarNumeros"})
public class GenerarNumeros extends HttpServlet {

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
        //creo el modelo a partir de la soliciud
        Generador generador = armarGeneradorDesdeSolicitud(request);
        String button09 = request.getParameter("09_button");
        String button01 = request.getParameter("01_button");
        int factorMultiplicativo = 1;
        if (button09 != null) {
            factorMultiplicativo = 9999;
        }
        float numeros[] = new float[20];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = generador.nextRandom() * factorMultiplicativo;
        }
        //Obtain the session object, create a new session if doesn't exist
        HttpSession session = request.getSession(true);
        
        
        //una vez generados los numeros aleatorios, lo envio al jsp para los muestre
        //en este caso lo asemos a nivel de sesion para que este accecible en toda la sesion de usuario,
        //cosa que nos permite compartir informacion.  Terminada la session, se destruye.
        session.setAttribute("numerosGenerados", numeros);
        session.setAttribute("generador", generador);
       
        //como cuando agrego va adepender de que boton aprete, paso el valor del factor en el request
        session.setAttribute("factorMultiplicativo", factorMultiplicativo);
        request.getRequestDispatcher("mostrarA.jsp").forward(request, response);
    }
    
    private Generador armarGeneradorDesdeSolicitud (HttpServletRequest request){
        //tomo los atributos de request y se los asigno al modelo
        float raiz = Float.parseFloat(request.getParameter("raiz"));
        float a = Float.parseFloat(request.getParameter("valorA"));
        float c = Float.parseFloat(request.getParameter("valorC"));
        float m = Float.parseFloat(request.getParameter("valorM"));
        String metodo = request.getParameter("metodo");
        
        //valido los datos que sean correctos, EN realidad se hace con javascript del lado del cliente
        if (raiz == 0) {
            request.getRequestDispatcher("error.jsp");
            return null;
        }
        
        
        return new Generador(raiz, a, c, m);
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
