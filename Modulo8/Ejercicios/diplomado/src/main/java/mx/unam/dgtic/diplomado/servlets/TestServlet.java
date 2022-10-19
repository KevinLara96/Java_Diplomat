package mx.unam.dgtic.diplomado.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet(urlPatterns = "/test")
public class TestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String nombre = request.getParameter("nombre");
        out.println("<p>Hola " + nombre + ", bienvenido</p>");

        String variableReq = (String) request.getSession().getAttribute("varReq"); // Igual que en el archivo JSP.
        out.println("<p>El valor de la variable request es: " + variableReq + "</p>");

        out.println("<p>Este es un párrafo</p>");
        out.println("<table>");
        for (int i = 0; i < 5; i++) {
            out.println("<tr>");
            out.println("<td>");
            out.println("Celda");
            out.println("</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
