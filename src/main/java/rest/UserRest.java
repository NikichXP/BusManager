package rest;

import com.google.gson.Gson;
import dao.UserDAO;
import dao.entity.UserEntity;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.sql.ResultSet;

@Path("user")
public class UserRest {

    private static UserDAO ud = UserDAO.getInstance();
    private static Gson gson = new Gson();

    @GET
    @Path("auth")
    /**
     * Authenticates user
     * @return Auth token
     */
    public String auth(@QueryParam("login") String login, @QueryParam("pass") String pass) {
        UserEntity u = UserDAO.getUser(login, pass);
        if (u == null) {
            return gson.toJson(new Error("No such user existing"));
        } else {
            return gson.toJson(u);
        }
    }

    @GET
    @Path("register")
    public String register(@QueryParam("login") String login, @QueryParam("pass") String pass, @QueryParam("name") String name,
                           @QueryParam("surname") String surname) {
        if (login == null || pass == null || name == null || surname == null) {
            return gson.toJson(new Error("One or more fields are null"));
        }
        UserDAO.createUser(login, pass, name, surname);
        return auth(login,pass);
    }

    @GET
    @Path("validate")
    public String validate (@QueryParam("token")String token) {
        return Boolean.toString(DataContainer.checkToken(token));
    }

    @GET
    @Path("delete")
    public String delete (@QueryParam("login")String login, @QueryParam("pass")String pass) {
        ResultSet rs = null;
        int id;
        try {
            rs = Query.query("Select id from user where login = \"" + login + "\" and password = \"" + pass + "\";");
            rs.first();
            Query.query("DELETE FROM user where login = \"" + login + "\" and password = \"" + pass + "\";");
            return gson.toJson(new Error("Success"));
        } catch (Exception e) {
            return gson.toJson(new Error(e.toString()));
        }
    }

    @GET
    @Path("edit")
    public String edit(@QueryParam("login") String login, @QueryParam("oldpass") String oldpass, @QueryParam("newpass") String newpass,
                       @QueryParam("name") String name, @QueryParam("capacity") String capacity, @QueryParam("car") String car,
                       @QueryParam("plate") String plate, @QueryParam("surname") String surname) {
        return "even more of text";
    }

}
