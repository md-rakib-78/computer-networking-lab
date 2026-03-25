import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args)throws IOException {
        ServerSocket server = new ServerSocket(5000);

        System.out.println("Waiting For client!");

        Socket s = server.accept();

        System.out.println("Client Connected!");

        DataInputStream input = new DataInputStream(s.getInputStream());

        String str ="";

        while (!str.equals("exit")) 
        {
            str = input.readUTF();
            System.out.println("Cliet Sent: "+str);
            
        }
        s.close();
        System.out.println("Socket Close!");

    }
    
}
