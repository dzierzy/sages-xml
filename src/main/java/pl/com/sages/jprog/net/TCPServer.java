package pl.com.sages.jprog.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

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
                System.out.println("connected...");

                PrintWriter writer = new PrintWriter(	connection.getOutputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                writer.println("Hello!");
                writer.flush();

                Scanner scanner = new Scanner(System.in);
                String msg = "";
                String received = "";
                while(!"quit".equalsIgnoreCase(msg) && received!=null){
                    System.out.print(">> ");
                    msg=scanner.nextLine();
                    writer.println(msg);
                    writer.flush();
                    received = reader.readLine();
                    System.out.println("received: " + received);

                }

                writer.flush();
                connection.close();
            }
        } catch (IOException e) { }

    }
}
