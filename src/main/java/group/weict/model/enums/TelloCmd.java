package group.weict.model.enums;

public enum TelloCmd {

    BACK("back");

    private final String cmd;

    public static String SPACE = " ";

    TelloCmd(String cmd) {
        this.cmd = cmd;
    }

    public String cmd(String options) {
        return this.name() + SPACE + options;
    }

}
