package frontend;

import logic.Thing;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowThingsServlet extends HttpServlet
{
    //Field

    //Constructor

    //Function

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Model model = Model.getInstance();
        List <Thing> list = model.getListThing();

        req.setAttribute("list", list);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("showList.jsp");
        requestDispatcher.forward(req, resp);
    }
}
