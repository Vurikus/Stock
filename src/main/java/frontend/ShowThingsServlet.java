package frontend;

import dao.SimpleConnection;
import logic.Thing;

import javax.jws.WebService;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ShowThingsServlet extends HttpServlet
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
        List <Thing> list = simpleConnection.selectFromDB();
        req.setAttribute("list", list);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("showList.jsp");
        requestDispatcher.forward(req, resp);
    }
}
