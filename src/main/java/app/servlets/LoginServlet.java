package app.servlets;

import app.entities.Admin;
import app.entities.Client;
import app.services.AdminService;
import app.services.ClientService;
import app.util.PasswordEncryptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/login.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = PasswordEncryptor.encryptWithMd5(req.getParameter("password"));
        String adminLogin = req.getParameter("admin_login");
        boolean isAdmin = false;

        if (adminLogin != null) {
            isAdmin = true;
        }

        HttpSession session = req.getSession();

        if (session.getAttribute("admin_data") == null && session.getAttribute("client_data") == null) {
            if (isAdmin) {
                AdminService service = new AdminService();
                Admin admin = service.login(email, password);

                if (admin != null) {
                    req.getSession().setAttribute("admin_data", admin);
                    resp.sendRedirect("/admin-page");
                } else {
                    req.setAttribute("login_error", "Invalid login! Try again or register!");
                    doGet(req, resp);
                }

            } else {
                ClientService service = new ClientService();
                Client client = service.login(email, password);

                if (client != null) {
                    req.getSession().setAttribute("client_data", client);
                    resp.sendRedirect("/client-page");
                } else {
                    req.setAttribute("login_error", "Invalid login! Try again or register!");
                    doGet(req, resp);
                }
            }

        } else {
            session.removeAttribute("client_data");
            session.removeAttribute("admin_data");
            doPost(req, resp);
        }
    }
}