package group.weict.service.udp;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import java.net.DatagramSocket;
import java.net.InetAddress;

@ApplicationScoped
public class ClientService {

    @ConfigProperty(name = "tello.ipaddress", defaultValue = "192.168.10.1")
    String ipaddress;

    @ConfigProperty(name = "tello.port", defaultValue = "8889")
    int port;

    private DatagramSocket datagramSocket;
    private InetAddress inetAddress;


    public String start() {
        return null;
    }

    public String cmd() {
        return null;
    }

    public String stop() {
        return null;
    }
}
