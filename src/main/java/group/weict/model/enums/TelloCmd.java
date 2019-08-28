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
     * Command to make the drone flip in a specified direction.
     */
    FLIP("flip");

    private final String cmd;

    public static String SPACE = " ";

    TelloCmd(String cmd) {
        this.cmd = cmd;
    }

    public String cmd(String options) {
        return this.name() + SPACE + options;
    }

}
