package ru.sbertech.tradehouse.web;

/**
 * Created by anton on 12/2/16.
 */
import javax.ws.rs.*;

@Path("/HelloWorld")
public class HelloWorldService {

    @GET
    @Path("/{id}")
    public String sayHello(@PathParam("id") String id) {
        return "<h1>Hello World:" + id + "</h1>";
    }


    @GET
    public String addUSer(@QueryParam("name") String name) {
        return "<h1>ADD new:" + name +"</h1>";
    }
}