package unam.dgtic.diplomado.controlador.servlet;

import java.io.IOException;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import unam.dgtic.diplomado.controlador.ejb.LoginEJB;
import unam.dgtic.diplomado.modelo.beans.login.BeanLogin;
import unam.dgtic.diplomado.modelo.entidades.empleado.EmpleadoEntity;

@WebServlet("/loginEmpleados")
public class LoginEmpleados extends HttpServlet {

    @EJB
    private LoginEJB servicioEjb;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        try {
            req.getRequestDispatcher("loginEmpleados.xhtml").forward(req, resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BeanLogin beanLogin = new BeanLogin();

        String correoLogin = beanLogin.getCorreo();
        String contrasenaLogin = beanLogin.getContrasena();

        EmpleadoEntity tmp = servicioEjb.login(correoLogin, contrasenaLogin);
        try {
            if (tmp == null) {
                resp.sendRedirect("inicioAdministracion.xhtml");
            } else {
                resp.sendRedirect("loginEmpleado?error=true");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
