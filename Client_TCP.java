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

// in main

       final int PORT = 8080;
        try(ServerSocket serverSocket = new ServerSocket(PORT)){
            while (true){
                Socket socket = serverSocket.accept();
                new Thread(()-> {
                    try {
                        procesareCerere(socket);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }).start();
            }
        
    

    static void procesareCerere(Socket socket) throws Exception{
        try {
            System.out.println("Astept client...");
            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) 
            {
                System.out.println("Am stabilit conexiunea!");
                int nrApPrimit =Integer.parseInt(in.readLine());
                for (var l : listaApartamente)
                {
                    if ( l.getNumarApartament() == nrApPrimit)
                        out.println(l.getNume());
                }
                System.out.println("Am terminat procesarea!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
