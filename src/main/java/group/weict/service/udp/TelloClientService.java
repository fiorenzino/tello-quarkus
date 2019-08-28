package group.weict.service.udp;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;
import java.net.*;

@ApplicationScoped
public class TelloClientService {

    @ConfigProperty(name = "tello.ipaddress", defaultValue = "192.168.10.1")
    String ipaddress;

    @ConfigProperty(name = "tello.port", defaultValue = "8889")
    int port;

    private DatagramSocket datagramSocket;
    private InetAddress inetAddress;


    public void start() throws Exception {
        datagramSocket = new DatagramSocket();
        inetAddress = InetAddress.getByName(ipaddress);
    }

    public String cmd(String message) throws Exception {
        if (!isStarted()) {
            throw new Exception(" the server id not started!");
        }
        final byte[] buffer = message.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, inetAddress, port);
        datagramSocket.send(packet);
        packet = new DatagramPacket(buffer, buffer.length);
        datagramSocket.receive(packet);
        return new String(packet.getData(), 0, packet.getLength());
    }

    public boolean isStarted() {
        return datagramSocket != null;
    }

    public void stop() throws Exception {
        if (datagramSocket != null && !datagramSocket.isClosed()) {
            datagramSocket.close();
        }
    }
}
