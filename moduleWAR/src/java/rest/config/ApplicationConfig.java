package rest.config;

import com.google.gson.Gson;
import rest.*;
import rest.Error;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import java.util.Set;

@ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }


    @GET
    @Path("/{arg}")
    public String getArg(@PathParam("arg") String arg) {
        return "{\"error\":\"No such path:\" " + arg + "}";
    }

    @GET
    @Path("/{arg}/{argv}")
    public String getArgs(@PathParam("arg") String arg, @PathParam("argv") String argv) {
        return "{\"error\":\"No such path:\" " + arg + " and param " + "}";
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
	resources.add(rest.AdminRest.class);
	resources.add(rest.DataRest.class);
	resources.add(rest.DeprecatedRouteRest.class);
	resources.add(rest.RouteRest.class);
	resources.add(rest.TestRest.class);
	resources.add(rest.UserRest.class);
	resources.add(rest.config.ApplicationConfig.class);
    }

}
