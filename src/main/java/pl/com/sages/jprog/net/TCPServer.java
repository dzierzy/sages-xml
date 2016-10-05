package pl.com.sages.jprog.net;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by marcin on 05.10.2016.
 */
public class TCPServer {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(3000);
            while(true) {
                // Wywołanie blokujące (accept)
                Socket connection = server.accept();
                PrintWriter writer = new PrintWriter(	connection.getOutputStream());
                writer.println("Hello!");
                writer.flush();
                connection.close();
            }
        } catch (IOException e) { }

    }
}
