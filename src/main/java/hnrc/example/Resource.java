package hnrc.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/")
public class Resource {

    @Path("publish")
    @GET
    public Response trigger(@QueryParam("msg") final String msg) {
        EventPublisher.pub(msg);
        return Response.ok().build();
    }

}
