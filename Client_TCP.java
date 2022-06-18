import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client_TCP {
    public static void main(String[] args) throws Exception{
        final int PORT = 8080;
        try(Socket socket = new Socket("127.0.0.1",PORT);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true)){

            System.out.println("M-am conectat la server!");
            out.println("1");
            System.out.println("Am trimis mesajul!");
            System.out.println("Raspuns: " + in.readLine());
        }
    }
}
