package mx.unam.diplomado.servlets;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.unam.diplomado.ejb.StatelessEJB;

import java.io.IOException;

@WebServlet("/index")
public class EjemploServlet extends HttpServlet {

    @EJB
    private StatelessEJB service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("resultado", service.saludar("Jorge"));
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
