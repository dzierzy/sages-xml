package pl.com.sages.jprog.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by marcin on 05.10.2016.
 */
public class TCPServer {

    public static void main(String[] args) {
        try {

            ServerSocket server = new ServerSocket(3000);

            ExecutorService es = Executors.newFixedThreadPool(2);

            System.out.println("waiting for a client on port " + server.getLocalPort() + " ...");
            Socket connection = server.accept();
            System.out.println("<< connected >>");

            PrintWriter writer = new PrintWriter(connection.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            writer.println("Hey! Anybody there?");
            writer.flush();

            // writer thread
            Runnable writerThread = new MessageWriter(writer);
            es.execute(writerThread);

            // reader thread
            Runnable readerThread = new MessageReader(reader);
            es.execute(readerThread);

            //connection.close();

            es.shutdown();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
