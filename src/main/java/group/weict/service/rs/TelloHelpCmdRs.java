package group.weict.service.rs;

import group.weict.model.enums.TelloCmd;
import group.weict.model.pojo.CmdResponse;

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
    @Path("/forward")
    public Response forward() throws Exception {
        return Response.ok(new CmdResponse(TelloCmd.FORWARD.cmd("20"), TelloCmd.FORWARD.help)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/left")
    public Response left() {
        return Response.ok(new CmdResponse(TelloCmd.LEFT.cmd("20"), TelloCmd.LEFT.help)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/right")
    public Response right() {
        return Response.ok(new CmdResponse(TelloCmd.RIGHT.cmd("20"), TelloCmd.RIGHT.help)).build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/up")
    public Response up() {
        return Response.ok(new CmdResponse(TelloCmd.UP.cmd("20"), TelloCmd.UP.help)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/ccw")
    public Response counterClockWise() {
        return Response.ok(new CmdResponse(TelloCmd.CCW.cmd("100"), TelloCmd.CCW.help)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/command")
    public Response command() {
        return Response.ok(new CmdResponse(TelloCmd.COMMAND.cmd(), TelloCmd.COMMAND.help)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/cw")
    public Response clockWise() {
        return Response.ok(new CmdResponse(TelloCmd.CW.cmd("100"), TelloCmd.CW.help)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/down")
    public Response down() {
        return Response.ok(new CmdResponse(TelloCmd.DOWN.cmd("20"), TelloCmd.DOWN.help)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/emergency")
    public Response emergency() {
        return Response.ok(new CmdResponse(TelloCmd.EMERGENCY.cmd(), TelloCmd.EMERGENCY.help)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/flipb")
    public Response flipb() {
        return Response.ok(new CmdResponse(TelloCmd.FLIP_B.cmd(), TelloCmd.FLIP_B.help)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/flipr")
    public Response flipr() {
        return Response.ok(new CmdResponse(TelloCmd.FLIP_R.cmd(), TelloCmd.FLIP_R.help)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/flipf")
    public Response flipf() {
        return Response.ok(new CmdResponse(TelloCmd.FLIP_F.cmd(), TelloCmd.FLIP_F.help)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/flipl")
    public Response flipl() {
        return Response.ok(new CmdResponse(TelloCmd.FLIP_L.cmd(), TelloCmd.FLIP_L.help)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/acceleration")
    public Response acceleration() {
        return Response.ok(new CmdResponse(TelloCmd.READ_ACCELERATION.cmd(), TelloCmd.READ_ACCELERATION.help)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/go")
    public Response go() {
        String positionX = "20";
        String positionY = "20";
        String positionZ = "20";
        String speed = "10";
        String cmd = TelloCmd.GO.cmd(TelloCmd.SPACE + positionX + TelloCmd.SPACE + positionY + TelloCmd.SPACE + positionZ + TelloCmd.SPACE + speed);
        return Response.ok(new CmdResponse(cmd, TelloCmd.GO.help)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/streamoff")
    public Response streamoff() {
        return Response.ok(new CmdResponse(TelloCmd.STREAMOFF.cmd(), TelloCmd.STREAMOFF.help)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/streamon")
    public Response streamon() {
        return Response.ok(new CmdResponse(TelloCmd.STREAMON.cmd(), TelloCmd.STREAMON.help)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/takeoff")
    public Response takeoff() {
        return Response.ok(new CmdResponse(TelloCmd.TAKEOFF.cmd(), TelloCmd.TAKEOFF.help)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/land")
    public Response land() {
        return Response.ok(new CmdResponse(TelloCmd.LAND.cmd(), TelloCmd.LAND.help)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/attitude")
    public Response attitude() {
        return Response.ok(new CmdResponse(TelloCmd.READ_ATTITUDE.cmd(), TelloCmd.READ_ATTITUDE.help)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/baro")
    public Response baro() {
        return Response.ok(new CmdResponse(TelloCmd.READ_BARO.cmd(), TelloCmd.READ_BARO.help)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/battery")
    public Response battery() {
        return Response.ok(new CmdResponse(TelloCmd.READ_BATTERY.cmd(), TelloCmd.READ_BATTERY.help)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/height")
    public Response height() {
        return Response.ok(new CmdResponse(TelloCmd.READ_HEIGHT.cmd(), TelloCmd.READ_HEIGHT.help)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/speed")
    public Response speed() {
        return Response.ok(new CmdResponse(TelloCmd.READ_SPEED.cmd(), TelloCmd.READ_SPEED.help)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/temp")
    public Response temp() {
        return Response.ok(new CmdResponse(TelloCmd.READ_TEMP.cmd(), TelloCmd.READ_TEMP.help)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/time")
    public Response time() {
        return Response.ok(new CmdResponse(TelloCmd.READ_TIME.cmd(), TelloCmd.READ_TIME.help)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/tof")
    public Response tof() {
        return Response.ok(new CmdResponse(TelloCmd.READ_TOF.cmd(), TelloCmd.READ_TOF.help)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/wifi")
    public Response wifi() {
        return Response.ok(new CmdResponse(TelloCmd.READ_WIFI.cmd(), TelloCmd.READ_WIFI.help)).build();
    }


}
