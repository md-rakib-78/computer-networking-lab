import java.io.*;
import java.net.*;

public class ser {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Waiting For client!");

        while (true) {
            Socket client = server.accept();
            System.out.println("Client Connected :" + client.getPort());

            new Thread(() -> {
                try {
                    DataOutputStream write = new DataOutputStream(client.getOutputStream());
                    DataInputStream input = new DataInputStream(client.getInputStream());
                    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

                    String msg = "";

                    while (!(msg = input.readUTF()).equals("exit")) {
                        System.out.println("Client Sent: "+ client.getPort()+" :"+ msg);
                        write.writeUTF(r.readLine());
                    }

                    client.close();
                    System.out.println("Client Disconnected: " + client.getPort());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
