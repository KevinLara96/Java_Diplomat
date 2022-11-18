package mx.unam.diplomado.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.unam.diplomado.ejb.StatelessJNDIEJB;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;

@WebServlet("/index")
public class EjemploServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	Map<String, Object> resultado = null;
    	StatelessJNDIEJB service = null;
    	try {
    		InitialContext ctx = new InitialContext();
    		service = (StatelessJNDIEJB) ctx.lookup("java:global/ejemplo-jndi/StatelessJNDIEJB!mx.unam.diplomado.ejb.StatelessJNDIEJB");
    		if (service != null) {
    			resultado = service.saludar("Jorge");
    			req.setAttribute("resultado", resultado);
    		} else {
    			req.setAttribute("resultado", new HashMap<String, Object>());
    		}
    	} catch (Exception ex) {
    		req.setAttribute("resultado", new HashMap<String, Object>());
    	}
        
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}