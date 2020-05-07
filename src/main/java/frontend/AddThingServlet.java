package frontend;

import dao.SimpleConnection;
import logic.Thing;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AddThingServlet extends HttpServlet
{
    //Field
    private SimpleConnection simpleConnection;
    //Constructor

    //Function


    @Override
    public void init() throws ServletException {
        try {
            simpleConnection = new SimpleConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("main.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = req.getParameter("name");
        int i = Integer.parseInt(req.getParameter("quantity"));
        float f = Float.parseFloat(req.getParameter("lifeTime"));
        simpleConnection.insertThingDB(new Thing(s, i, f));
        doGet(req, resp);
    }
}
