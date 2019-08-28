package group.weict.service.udp;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import io.quarkus.scheduler.Scheduled;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

@ApplicationScoped
public class TelloStateService {


    private static final Logger logger = LoggerFactory.getLogger(TelloStateService.class);
    private DatagramSocket datagramSocket;

    @ConfigProperty(name = "tello.log.port", defaultValue = "8890")
    int port;

    private boolean running = false;
    private boolean showingLogs = false;
    private byte[] buf = new byte[256];


    void onStart(@Observes StartupEvent startupEvent) {
        logger.info("The TelloStateService is starting...");
        start();
    }

    void onStop(@Observes ShutdownEvent shutdownEvent) {
        logger.info("The TelloStateService is stopping...");
        stop();
        close();
    }

    @Scheduled(every = "1s")
    private void run() {
        if (!running) {
            return;
        }
        String msg;
        if (showingLogs)
            logger.info("TelloStateService is waiting for...");
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        try {
            datagramSocket.receive(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        msg = new String(packet.getData(), 0, packet.getLength());
        if (showingLogs)
            logger.info("Message from " + packet.getAddress().getHostAddress() + ": " + msg);


    }

    public void start() {
        try {
            datagramSocket = new DatagramSocket(this.port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        this.running = false;
    }


    public void close() {

        if (datagramSocket != null && !datagramSocket.isClosed()) {
            datagramSocket.close();
            logger.info("TelloStateService is closed...");
        }
    }
}
