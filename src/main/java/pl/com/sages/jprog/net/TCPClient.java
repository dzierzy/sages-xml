package pl.com.sages.jprog.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by marcin on 05.10.2016.
 */
public class TCPClient {

    public static void main(String[] args) {
        try {

            ExecutorService es = Executors.newFixedThreadPool(2);

            Socket s = new Socket("localhost", 3000);

            BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter writer = new PrintWriter(s.getOutputStream());

            // writer thread
            Runnable writerThread = new MessageWriter(writer);
            es.execute(writerThread);

            // reader thread
            Runnable readerThread = new MessageReader(reader);
            es.execute(readerThread);

            es.shutdown();

        } catch (UnknownHostException e) {
        } catch (IOException e) {
        }
    }
}
