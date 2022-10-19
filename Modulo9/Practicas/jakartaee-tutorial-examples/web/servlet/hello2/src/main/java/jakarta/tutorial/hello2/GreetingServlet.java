/*
 * Copyright (c) 2014, 2020 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package jakarta.tutorial.hello2;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * This is a simple example of an HTTP Servlet. It responds to the GET method of
 * the HTTP protocol.
 */
@WebServlet("/greeting")
public class GreetingServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setBufferSize(8192);
        try (PrintWriter out = response.getWriter()) {
            out.println("<html lang=\"en\">"
                    + "<head><title>Servlet Hello</title></head>");

            // then write the data of the response
            out.println("<body  bgcolor=\"#ffffff\">"
                    + "<img src=\"resources/images/duke.waving.gif\" "
                    + "alt=\"Duke waving his hand\">"
                    + "<form method=\"get\">"
                    + "<h2>Hola, mi nombre es Duke,  ¿cuál es tu nombre?</h2>"
                    + "<input title=\"Mi nombre es: \" type=\"text\" "
                    + "name=\"username\" size=\"25\"/>"
                    + "<p></p>"
                    + "<h2>¿Cuál es tu edad?</h2>"
                    + "<input title=\"Mi edad es: \" type=\"text\" "
                    + "name=\"edad\" size=\"25\"/>"
                    + "<p></p>"
                    + "<input type=\"submit\" value=\"Enviar\"/>"
                    + "<input type=\"reset\" value=\"Limpiar\"/>"
                    + "</form>");

            String username = request.getParameter("username");
            String edad = request.getParameter("edad");
            if (username != null && username.length() > 0) {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/response");

                if (dispatcher != null) {
                    dispatcher.include(request, response);
                }
            }
            if (edad != null && edad.length() > 0) {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/response");

                if (dispatcher != null) {
                    dispatcher.include(request, response);
                }
            }
            out.println("</body></html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "The Hello servlet says hello.";

    }
}
