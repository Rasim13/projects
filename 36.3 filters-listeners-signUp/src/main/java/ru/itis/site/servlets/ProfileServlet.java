package ru.itis.site.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String color = request.getParameter("color");
        String colorStyle = "style=\"color:";

        if(color == null) {
            String cookiesHeader = request.getHeader("color");

            if (cookiesHeader != null) {
                String[] cookies = cookiesHeader.split("; ");

                for (String cookie: cookies) {
                    if (cookie.split("=")[0].equals("color")) {
                        color = cookie.split("=")[1];
                    }
                }
            }
            
            if (color == null) {
                colorStyle = "black";
            }

        } else {
            response.setHeader("set-cookie", "color=" + color);
        }

        colorStyle = colorStyle + color + "\"";
        response.getWriter().println("<h1 " + colorStyle + "> Rasim!</h1>");
    }
}
