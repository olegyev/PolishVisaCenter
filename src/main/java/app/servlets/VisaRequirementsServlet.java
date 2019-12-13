package app.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class VisaRequirementsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestPath = req.getServletPath();
        RequestDispatcher requestDispatcher;

        String visaC = "/c-visa";
        String visaD = "/d-visa";

        if (requestPath.equals(visaC)) {
            requestDispatcher = req.getRequestDispatcher("views/c_visa.jsp");
            requestDispatcher.forward(req, resp);
        } else if (requestPath.equals(visaD)) {
            requestDispatcher = req.getRequestDispatcher("views/d_visa.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}