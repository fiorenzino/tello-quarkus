package group.weict.service.rs;

import group.weict.model.enums.TelloCmd;
import group.weict.model.pojo.CmdResponse;
import group.weict.service.udp.TelloClientService;

import javax.inject.Inject;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cmd")
public class TelloCmdRs {

    @Inject
    TelloClientService telloClientService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/back")
    public Response back(
            @Min(message = "the distance in cm, minimum 20", value = 20)
            @Max(message = "the distance in cm maximum 500", value = 500)
            @DefaultValue("20")
            @QueryParam("distanceInCm") int distanceInCm) throws Exception {
        System.out.println(distanceInCm);
        String cmd = TelloCmd.BACK.cmd("" + distanceInCm);
        String ret = telloClientService.cmd(cmd);
        return Response.ok(new CmdResponse(cmd, ret)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/ccw")
    public Response counterClockWise(
            @Min(message = "the rasdius in degrees, minimum 1", value = 1)
            @Max(message = "the radius in degrees, maximum 3600", value = 3600)
            @DefaultValue("100")
            @QueryParam("degrees") int degrees) throws Exception {
        System.out.println(degrees);
        String cmd = TelloCmd.CCW.cmd("" + degrees);
        String ret = telloClientService.cmd(cmd);
        return Response.ok(new CmdResponse(cmd, ret)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/command")
    public Response command() throws Exception {
        String cmd = TelloCmd.COMMAND.cmd();
        String ret = telloClientService.cmd(cmd);
        return Response.ok(new CmdResponse(cmd, ret)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/cw")
    public Response clockWise(
            @Min(message = "the rasdius in degrees, minimum 1", value = 1)
            @Max(message = "the radius in degrees, maximum 3600", value = 3600)
            @DefaultValue("100")
            @QueryParam("degrees")
                    int degrees) throws Exception {
        System.out.println(degrees);
        String cmd = TelloCmd.CW.cmd("" + degrees);
        String ret = telloClientService.cmd(cmd);
        return Response.ok(new CmdResponse(cmd, ret)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/down")
    public Response down(
            @Min(message = "the distance in cm, minimum 20", value = 20)
            @Max(message = "the distance in cm maximum 500", value = 500)
            @DefaultValue("20")
            @QueryParam("distanceInCm") int distanceInCm) throws Exception {
        System.out.println(distanceInCm);
        String cmd = TelloCmd.DOWN.cmd("" + distanceInCm);
        String ret = telloClientService.cmd(cmd);
        return Response.ok(new CmdResponse(cmd, ret)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/emergency")
    public Response emergency() throws Exception {
        String cmd = TelloCmd.EMERGENCY.cmd();
        String ret = telloClientService.cmd(cmd);
        return Response.ok(new CmdResponse(cmd, ret)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/flipb")
    public Response flipb() throws Exception {
        String cmd = TelloCmd.FLIP_B.cmd();
        String ret = telloClientService.cmd(cmd);
        return Response.ok(new CmdResponse(cmd, ret)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/flipr")
    public Response flipr() throws Exception {
        String cmd = TelloCmd.FLIP_R.cmd();
        String ret = telloClientService.cmd(cmd);
        return Response.ok(new CmdResponse(cmd, ret)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/flipf")
    public Response flipf() throws Exception {
        String cmd = TelloCmd.FLIP_F.cmd();
        String ret = telloClientService.cmd(cmd);
        return Response.ok(new CmdResponse(cmd, ret)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/flipl")
    public Response flipl() throws Exception {
        String cmd = TelloCmd.FLIP_L.cmd();
        String ret = telloClientService.cmd(cmd);
        return Response.ok(new CmdResponse(cmd, ret)).build();
    }


}
