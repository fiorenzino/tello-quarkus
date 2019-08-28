package group.weict.service.rs;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cmd")
public class TelloCmdRs {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/back")
    public Response back(
            @Min(message = "the distance in cm, minimum 20", value = 20)
            @Max(message = "the distance in cm maximum 500", value = 500)
            @DefaultValue("20")
            @QueryParam("distanceInCm") int distanceInCm) throws Exception {
        System.out.println(distanceInCm);
        return Response.ok("back " + distanceInCm).build();
    }
}
