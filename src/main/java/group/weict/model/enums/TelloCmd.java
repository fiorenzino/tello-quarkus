package group.weict.model.enums;

public enum TelloCmd {


    BACK("back", "Command to make the drone fly backwards by a specified distance: the distance in cm, minimum 20, maximum 500"),
    CCW("ccw", "Command to make the drone rotate in a counter-clockwise direction by a specified amount of degrees: the radius in degrees, minimum 1,maximum 360"),
    COMMAND("command", "Command to make the drone enter SDK mode. This command has to be executed before executing any of the other commands."),
    CW("cw", "Command to make the drone rotate in a clockwise direction by a specified amount of degrees."),
    DOWN("down", "Command to make the drone descend by a specified distance."),
    EMERGENCY("emergency", "Command to stop all the motors immediately."),
    FLIP_L("flip l", "Command to make the drone flip in a left direction."),
    FLIP_R("flip r", "Command to make the drone flip in a right direction."),
    FLIP_F("flip f", "Command to make the drone flip in a forward direction."),
    FLIP_B("flip b", "Command to make the drone flip in a back direction."),
    FORWARD("forward", "Command to make the drone fly forward by a specified distance."),
    GO("go", "Command to make the drone fly to position x, y, z by a specified speed."),
    LAND("land", "Command to land the drone automatically."),
    LEFT("left", "Command to make the drone fly left by a specified distance."),
    RIGHT("right", "Command to make the drone fly right by a specified distance."),
    STREAMOFF("streamoff", "Command to disable the video stream."),
    STREAMON("streamon", "Command to enable the video stream."),
    TAKEOFF("takeoff", "Command to take off automatically."),
    UP("up", "Command to make the drone ascend by a specified distance."),

    // READ CMDS
    READ_ACCELERATION("acceleration?", "Command to get IMU acceleration data in 0.001g."),
    READ_ATTITUDE("attitude?", "Command to get IMU attitude data."),
    READ_BARO("baro?", "Command to get the current barometer value in m."),
    READ_BATTERY("battery?", "Command to get the current battery percentage."),
    READ_HEIGHT("height?", "Command to get the current height in cm."),
    READ_SPEED("speed?", "Command to get the current speed in cm/s."),
    READ_TEMP("temp?", "Command to get the current temperature in degrees celsius."),
    READ_TIME("time?", "Command to get the current flight time in seconds."),
    READ_TOF("tof?", "Command to get distance value from tof in cm."),
    READ_WIFI("wifi?", "Command to get the wifi SNR."),


    //SET CMD
    SET_SPEED("speed", "Command to set the speed.");


    public final String cmd;
    public final String help;

    public static String SPACE = " ";

    TelloCmd(String cmd, String help) {
        this.cmd = cmd;
        this.help = help;
    }

    public String cmd(String options) {
        return this.cmd + SPACE + options;
    }

    public String cmd() {
        return this.name();
    }

}
