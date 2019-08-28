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

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/start")
    public Response start() throws Exception {
        System.out.println("start");
        telloClientService.start();
        return Response.ok(new CmdResponse("start", "ok")).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stop")
    public Response stop() throws Exception {
        System.out.println("stop");
        telloClientService.stop();
        return Response.ok(new CmdResponse("stop", "ok")).build();
    }

    @POST
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

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/forward")
    public Response forward(
            @Min(message = "the distance in cm, minimum 20", value = 20)
            @Max(message = "the distance in cm maximum 500", value = 500)
            @DefaultValue("20")
            @QueryParam("distanceInCm") int distanceInCm) throws Exception {
        System.out.println(distanceInCm);
        String cmd = TelloCmd.FORWARD.cmd("" + distanceInCm);
        String ret = telloClientService.cmd(cmd);
        return Response.ok(new CmdResponse(cmd, ret)).build();
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/left")
    public Response left(
            @Min(message = "the distance in cm, minimum 20", value = 20)
            @Max(message = "the distance in cm maximum 500", value = 500)
            @DefaultValue("20")
            @QueryParam("distanceInCm") int distanceInCm) throws Exception {
        System.out.println(distanceInCm);
        String cmd = TelloCmd.LEFT.cmd("" + distanceInCm);
        String ret = telloClientService.cmd(cmd);
        return Response.ok(new CmdResponse(cmd, ret)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/right")
    public Response right(
            @Min(message = "the distance in cm, minimum 20", value = 20)
            @Max(message = "the distance in cm maximum 500", value = 500)
            @DefaultValue("20")
            @QueryParam("distanceInCm") int distanceInCm) throws Exception {
        System.out.println(distanceInCm);
        String cmd = TelloCmd.RIGHT.cmd("" + distanceInCm);
        String ret = telloClientService.cmd(cmd);
        return Response.ok(new CmdResponse(cmd, ret)).build();
    }

    @POST
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

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/up")
    public Response up(
            @Min(message = "the distance in cm, minimum 20", value = 20)
            @Max(message = "the distance in cm maximum 500", value = 500)
            @DefaultValue("20")
            @QueryParam("distanceInCm") int distanceInCm) throws Exception {
        System.out.println(distanceInCm);
        String cmd = TelloCmd.UP.cmd("" + distanceInCm);
        String ret = telloClientService.cmd(cmd);
        return Response.ok(new CmdResponse(cmd, ret)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/ccw")
    public Response counterClockWise(
            @Min(message = "the rasdius in degrees, minimum 1", value = 1)
            @Max(message = "the radius in degrees, maximum 360", value = 360)
            @DefaultValue("180")
            @QueryParam("degrees") int degrees) throws Exception {
        System.out.println(degrees);
        String cmd = TelloCmd.CCW.cmd("" + degrees);
        String ret = telloClientService.cmd(cmd);
        return Response.ok(new CmdResponse(cmd, ret)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/set_speed")
    public Response set_speed() {
        return Response.ok(new CmdResponse(TelloCmd.SET_SPEED.cmd("10"), TelloCmd.SET_SPEED.help)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/go")
    public Response go(
            @Min(message = "the x position, minimum 20", value = 20)
            @Max(message = "the x position, maximum 500", value = 500)
            @DefaultValue("20")
            @QueryParam("positionX") int positionX,

            @Min(message = "the y position, minimum 20", value = 20)
            @Max(message = "the y position, maximum 500", value = 500)
            @DefaultValue("20")
            @QueryParam("positionY") int positionY,

            @Min(message = "the z position, minimum 20", value = 20)
            @Max(message = "the z position, maximum 500", value = 500)
            @DefaultValue("20")
            @QueryParam("positionZ") int positionZ,

            @Min(message = "the speed, minimum 10", value = 10)
            @Max(message = "the speed, maximum 100", value = 100)
            @DefaultValue("10")
            @QueryParam("speed") int speed) throws Exception {
        System.out.println("positionX: " + positionX + ",positionY: " + positionY + ",positionZ: " + positionZ + ",speed: " + speed);
        String cmd = TelloCmd.GO.cmd(TelloCmd.SPACE + positionX + TelloCmd.SPACE + positionY + TelloCmd.SPACE + positionZ + TelloCmd.SPACE + speed);
        String ret = telloClientService.cmd(cmd);
        return Response.ok(new CmdResponse(cmd, ret)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/streamoff")
    public Response streamoff() throws Exception {
        String cmd = TelloCmd.STREAMOFF.cmd();
        String ret = telloClientService.cmd(cmd);
        return Response.ok(new CmdResponse(cmd, ret)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/streamon")
    public Response streamon() throws Exception {
        String cmd = TelloCmd.STREAMON.cmd();
        String ret = telloClientService.cmd(cmd);
        return Response.ok(new CmdResponse(cmd, ret)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/takeoff")
    public Response takeoff() throws Exception {
        String cmd = TelloCmd.TAKEOFF.cmd();
        String ret = telloClientService.cmd(cmd);
        return Response.ok(new CmdResponse(cmd, ret)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/land")
    public Response land() throws Exception {
        String cmd = TelloCmd.LAND.cmd();
        String ret = telloClientService.cmd(cmd);
        return Response.ok(new CmdResponse(cmd, ret)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/command")
    public Response command() throws Exception {
        String cmd = TelloCmd.COMMAND.cmd();
        String ret = telloClientService.cmd(cmd);
        return Response.ok(new CmdResponse(cmd, ret)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/cw")
    public Response clockWise(
            @Min(message = "the rasdius in degrees, minimum 1", value = 1)
            @Max(message = "the radius in degrees, maximum 360", value = 360)
            @DefaultValue("180")
            @QueryParam("degrees")
                    int degrees) throws Exception {
        System.out.println(degrees);
        String cmd = TelloCmd.CW.cmd("" + degrees);
        String ret = telloClientService.cmd(cmd);
        return Response.ok(new CmdResponse(cmd, ret)).build();
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/emergency")
    public Response emergency() throws Exception {
        String cmd = TelloCmd.EMERGENCY.cmd();
        String ret = telloClientService.cmd(cmd);
        return Response.ok(new CmdResponse(cmd, ret)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/flipb")
    public Response flipb() throws Exception {
        String cmd = TelloCmd.FLIP_B.cmd();
        String ret = telloClientService.cmd(cmd);
        return Response.ok(new CmdResponse(cmd, ret)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/flipr")
    public Response flipr() throws Exception {
        String cmd = TelloCmd.FLIP_R.cmd();
        String ret = telloClientService.cmd(cmd);
        return Response.ok(new CmdResponse(cmd, ret)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/flipf")
    public Response flipf() throws Exception {
        String cmd = TelloCmd.FLIP_F.cmd();
        String ret = telloClientService.cmd(cmd);
        return Response.ok(new CmdResponse(cmd, ret)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/flipl")
    public Response flipl() throws Exception {
        String cmd = TelloCmd.FLIP_L.cmd();
        String ret = telloClientService.cmd(cmd);
        return Response.ok(new CmdResponse(cmd, ret)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/acceleration")
    public Response acceleration() throws Exception {
        String cmd = TelloCmd.READ_ACCELERATION.cmd();
        String ret = telloClientService.cmd(cmd);
        return Response.ok(new CmdResponse(cmd, ret)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/attitude")
    public Response attitude() throws Exception {
        String cmd = TelloCmd.READ_ATTITUDE.cmd();
        String ret = telloClientService.cmd(cmd);
        return Response.ok(new CmdResponse(cmd, ret)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/baro")
    public Response baro() throws Exception {
        String cmd = TelloCmd.READ_BARO.cmd();
        String ret = telloClientService.cmd(cmd);
        return Response.ok(new CmdResponse(cmd, ret)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/battery")
    public Response battery() throws Exception {
        String cmd = TelloCmd.READ_BATTERY.cmd();
        String ret = telloClientService.cmd(cmd);
        return Response.ok(new CmdResponse(cmd, ret)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/height")
    public Response height() throws Exception {
        String cmd = TelloCmd.READ_HEIGHT.cmd();
        String ret = telloClientService.cmd(cmd);
        return Response.ok(new CmdResponse(cmd, ret)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/speed")
    public Response speed() throws Exception {
        String cmd = TelloCmd.READ_SPEED.cmd();
        String ret = telloClientService.cmd(cmd);
        return Response.ok(new CmdResponse(cmd, ret)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/temp")
    public Response temp() throws Exception {
        String cmd = TelloCmd.READ_TEMP.cmd();
        String ret = telloClientService.cmd(cmd);
        return Response.ok(new CmdResponse(cmd, ret)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/time")
    public Response time() throws Exception {
        String cmd = TelloCmd.READ_TIME.cmd();
        String ret = telloClientService.cmd(cmd);
        return Response.ok(new CmdResponse(cmd, ret)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/tof")
    public Response tof() throws Exception {
        String cmd = TelloCmd.READ_TOF.cmd();
        String ret = telloClientService.cmd(cmd);
        return Response.ok(new CmdResponse(cmd, ret)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/wifi")
    public Response wifi() throws Exception {
        String cmd = TelloCmd.READ_WIFI.cmd();
        String ret = telloClientService.cmd(cmd);
        return Response.ok(new CmdResponse(cmd, ret)).build();
    }


}
