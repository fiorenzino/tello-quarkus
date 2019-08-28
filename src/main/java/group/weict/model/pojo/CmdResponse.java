package group.weict.model.pojo;

public class CmdResponse {
    public String cmd;
    public String response;

    public CmdResponse(String cmd, String response) {
        this.cmd = cmd;
        this.response = response;
    }

    @Override
    public String toString() {
        return "CmdResponse{" +
                "cmd='" + cmd + '\'' +
                ", response='" + response + '\'' +
                '}';
    }
}
