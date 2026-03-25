import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String[] args)throws IOException {
        Socket client = new Socket("192.168.0.168",5000);
        System.out.println("Server connected!");

        DataOutputStream output = new DataOutputStream(client.getOutputStream());

        BufferedReader read=new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while(!str.equals("exit"))
        {
            str = read.readLine();
            output.writeUTF(str);

        }
        client.close();
        System.out.println("Connection Closed!");
    }
}
