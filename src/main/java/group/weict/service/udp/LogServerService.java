package group.weict.service.udp;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

@ApplicationScoped
public class LogServerService {

    private DatagramSocket datagramSocket;

    @ConfigProperty(name = "tello.log.port", defaultValue = "8890")
    int port;

    private boolean running = false;
    private boolean showingLogs = false;
    private byte[] buf = new byte[256];

    public void run() {
        running = true;
        String msg;

        while (running) {
            if (showingLogs)
                System.out.println("log server is waiting for logs...");
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            try {
                datagramSocket.receive(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
            msg = new String(packet.getData(), 0, packet.getLength());
            if (showingLogs)
                System.out.println("Message from " + packet.getAddress().getHostAddress() + ": " + msg);
        }
        if (datagramSocket != null && !datagramSocket.isClosed()) {
            datagramSocket.close();
        }
        System.out.println("log server is closed...");

    }


    public void close() {
        this.running = false;
        System.out.println("Machine is stopping.");
    }

    public void show() {
        this.showingLogs = true;
        System.out.println("show logs: ok");
    }

    public void hide() {
        this.showingLogs = false;
        System.out.println("hide logs: ok");
    }
}
