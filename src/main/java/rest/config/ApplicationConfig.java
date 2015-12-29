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

    /**
     * Method contains java classes which are included to ReST service
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(DataRest.class);
        resources.add(TestRest.class);
        resources.add(DeprecatedRouteRest.class);
        resources.add(RouteRest.class);
        resources.add(UserRest.class);
        resources.add(AdminRest.class);
        resources.add(ApplicationConfig.class);
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

}
