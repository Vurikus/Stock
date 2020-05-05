package frontend;

import dao.SimpleConnection;
import logic.Thing;

import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("/jersey")
public class JerseyServlet {
    //Field

    //Constructor

    //Function
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Thing check (@PathParam("id") int id) throws SQLException, NamingException {
        SimpleConnection simpleConnection = new SimpleConnection();
        List <Thing> list = simpleConnection.selectFromDB();
        return list.get(id);
    }
}
