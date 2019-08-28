package group.weict.model.enums;

public enum TelloCmd {

    /**
     * Command to make the drone fly backwards by a specified distance.
     */
    BACK("back"),
    /**
     * Command to make the drone rotate in a counter-clockwise direction by a specified amount of degrees.
     */
    CCW("ccw"),
    /**
     * Command to make the drone enter SDK mode. This command has to be executed before executing any of the other
     * commands.
     */
    COMMAND("command"),
    /**
     * Command to make the drone rotate in a clockwise direction by a specified amount of degrees.
     */
    CW("cw"),
    /**
     * Command to make the drone descend by a specified distance.
     */
    DOWN("down"),
    /**
     * Command to stop all the motors immediately.
     */
    EMERGENCY("emergency"),
    /**
     * Command to make the drone flip in a left direction.
     */
    FLIP_L("flip l"),
    /**
     * Command to make the drone flip in a right direction.
     */
    FLIP_R("flip r"),
    /**
     * Command to make the drone flip in a forward direction.
     */
    FLIP_F("flip f"),
    /**
     * Command to make the drone flip in a back direction.
     */
    FLIP_B("flip b"),

    /**
     * Command to make the drone fly forward by a specified distance.
     */
    FORWARD("forward"),
    /**
     * Command to make the drone fly to position x, y, z by a specified speed.
     */
    GO("go"),
    /**
     * Command to land the drone automatically.
     */
    LAND("land"),

    /**
     * Command to make the drone fly left by a specified distance.
     */
    LEFT("left"),

    /**
     * Command to make the drone fly right by a specified distance.
     */
    RIGHT("right"),
    /**
     * Command to disable the video stream.
     */
    STREAMOFF("streamoff"),

    /**
     * Command to enable the video stream.
     */
    STREAMON("streamon"),

    /**
     * Command to take off automatically.
     */
    TAKEOFF("takeoff"),
    /**
     * Command to make the drone ascend by a specified distance.
     */
    UP("up"),

    // READ CMDS
    /**
     * Command to get IMU acceleration data in 0.001g.
     */
    READ_ACCELERATION("acceleration?"),
    /**
     * Command to get IMU attitude data.
     */
    READ_ATTITUDE("attitude?"),
    /**
     * Command to get the current barometer value in m.
     */
    READ_BARO("baro?"),
    /**
     * Command to get the current battery percentage.
     */
    READ_BATTERY("battery?"),

    /**
     * Command to get the current height in cm.
     */
    READ_HEIGHT("height?"),

    /**
     * Command to get the current speed in cm/s.
     */
    READ_SPEED("speed?"),

    /**
     * Command to get the current temperature in degrees celsius.
     */
    READ_TEMP("temp?"),

    /**
     * Command to get the current flight time in seconds.
     */
    READ_TIME("time?"),

    /**
     * Command to get distance value from tof in cm.
     */
    READ_TOF("tof?"),

    /**
     * Command to get the wifi SNR.
     */
    READ_WIFI("wifi?"),


    //SET CMD

    /**
     * Command to set the speed.
     */
    SET_WIFI("speed");


    private final String cmd;

    public static String SPACE = " ";

    TelloCmd(String cmd) {
        this.cmd = cmd;
    }

    public String cmd(String options) {
        return this.name() + SPACE + options;
    }

}
