import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 通过socket发送口令关闭服务器
 *
 * @author Ville
 * @date 2018/6/28
 */
public class ShutdownTomcat {

    public static void main(String[] args) {
        try (Socket socket = new Socket("192.168.20.2", 8002)) {
            OutputStream out = socket.getOutputStream();
            out.write("SHUTDOWN".getBytes());
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
