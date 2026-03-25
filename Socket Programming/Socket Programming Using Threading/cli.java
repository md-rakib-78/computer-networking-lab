import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class cli {
    public static void main(String[] args)throws IOException {
        Socket client = new Socket("192.168.0.168",5000);
        System.out.println("Server connected!");

        // Msg Write
        DataOutputStream write = new DataOutputStream(client.getOutputStream());
        // Msg Read
        DataInputStream read = new DataInputStream(client.getInputStream());

        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        String str = "";

        while(!str.equals("exit"))
        {
            str = r.readLine();
            write.writeUTF(str);
            
            System.out.println("Server: "+read.readUTF());

        }
        client.close();
        System.out.println("Connection Closed!");
    }
}
