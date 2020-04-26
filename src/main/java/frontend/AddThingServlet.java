package frontend;

import logic.Thing;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AddThingServlet extends HttpServlet
{
    //Field
    //Constructor

    //Function

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("main.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = req.getParameter("name");
        int i = Integer.parseInt(req.getParameter("quantity"));
        Model model = Model.getInstance();
        model.add(new Thing(s, i));
        doGet(req, resp);
    }
}
