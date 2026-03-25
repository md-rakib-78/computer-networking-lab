import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args)throws IOException {
        ServerSocket server = new ServerSocket(5000);

        System.out.println("Waiting For client!");

        Socket s = server.accept();

        System.out.println("Client Connected!");

        // Server msg write
        DataOutputStream write = new DataOutputStream(s.getOutputStream());

        // Server Msg Read
        DataInputStream input = new DataInputStream(s.getInputStream());

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        String str ="";

        while (!input.readUTF().equals("exit")) 
        {
            System.out.println("Cliet Sent: "+input.readUTF());
            write.writeUTF(r.readLine());

            
        }
        s.close();
        System.out.println("Socket Close!");

    }
    
}