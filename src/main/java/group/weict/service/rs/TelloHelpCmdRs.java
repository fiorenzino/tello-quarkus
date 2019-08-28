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

@Path("/help")
public class TelloHelpCmdRs {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/back")
    public Response back() {
        return Response.ok(new CmdResponse(TelloCmd.BACK.cmd("20"), TelloCmd.BACK.help)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/ccw")
    public Response counterClockWise() throws Exception {
        return Response.ok(new CmdResponse(TelloCmd.CCW.cmd("100"), TelloCmd.CCW.help)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/command")
    public Response command() throws Exception {
        return Response.ok(new CmdResponse(TelloCmd.COMMAND.cmd(), TelloCmd.COMMAND.help)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/cw")
    public Response clockWise() throws Exception {
        return Response.ok(new CmdResponse(TelloCmd.CW.cmd("100"), TelloCmd.CW.help)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/down")
    public Response down() throws Exception {
        return Response.ok(new CmdResponse(TelloCmd.DOWN.cmd("20"), TelloCmd.DOWN.help)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/emergency")
    public Response emergency() throws Exception {
        return Response.ok(new CmdResponse(TelloCmd.EMERGENCY.cmd(), TelloCmd.EMERGENCY.help)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/flipb")
    public Response flipb() throws Exception {
        return Response.ok(new CmdResponse(TelloCmd.FLIP_B.cmd(), TelloCmd.FLIP_B.help)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/flipr")
    public Response flipr() throws Exception {
        return Response.ok(new CmdResponse(TelloCmd.FLIP_R.cmd(), TelloCmd.FLIP_R.help)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/flipf")
    public Response flipf() throws Exception {
        return Response.ok(new CmdResponse(TelloCmd.FLIP_F.cmd(), TelloCmd.FLIP_F.help)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/flipl")
    public Response flipl() throws Exception {
        return Response.ok(new CmdResponse(TelloCmd.FLIP_L.cmd(), TelloCmd.FLIP_L.help)).build();
    }


}
