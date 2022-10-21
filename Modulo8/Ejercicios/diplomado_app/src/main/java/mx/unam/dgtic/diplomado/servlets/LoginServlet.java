/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.dgtic.diplomado.servlets;

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
 * @author JAVA
 */
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private static final String PANTALLA_LOGIN = "/login/login.jsp";
    private static final String PANTALLA_CONTROLLER = "/controller";
    private static final String PARAMETRO_ACCION = "accion";

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
        System.out.println("ENTRAMOS POR GET EN LOGIN");
        String accion = request.getParameter(PARAMETRO_ACCION);
        if (accion != null && accion.equals("")) {

        } else {
            request.getRequestDispatcher(PANTALLA_LOGIN).forward(request, response);
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
        //validacion de datos
        HttpSession session;
        String nombre = (String) request.getParameter("usuario");
        String password = (String) request.getParameter("password");        
        if (nombre != null && password != null) { //si pasa la validacion
        	System.out.println(nombre);
            session = request.getSession();
            session.setAttribute("nombre", nombre);
            request.setAttribute("nombre", nombre);
            request.getRequestDispatcher(PANTALLA_CONTROLLER).forward(request, response);
        } else {
            request.getRequestDispatcher(PANTALLA_LOGIN).forward(request, response);
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
