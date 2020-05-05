package frontend.user;

import logic.user.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*String login = (String) request.getParameter("login");
        //String email = (String) request.getAttribute("email");
        String password = (String) request.getParameter("password");
        Model model = Model.getInstance();
        List<User> listUsers = model.getListUser();
        boolean error = false;
        for (User user: listUsers) {
            if(login.equals(user.getLogin())){
                if (password.equals(user.getPassword())){
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }
                else {
                    request.setAttribute("error", "password error");
                    error = true;
                }
            }
            else {
                request.setAttribute("error", "Not found User");
                error = true;
            }
        }
        if (error) {
            doGet(request,response);
        }*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
