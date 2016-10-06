package pl.com.sages.jprog.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by marcin on 05.10.2016.
 */
public class TCPClient {

    public static void main(String[] args) {
        try {
            Socket s = new Socket("192.168.1.114", 3000);
            BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter writer = new PrintWriter(s.getOutputStream());
            Scanner scanner = new Scanner(System.in);

            String line = null;
            // Wywołanie blokujące (readLine)
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                writer.write(scanner.nextLine());
            }
            // 192.168.1.212

        } catch (UnknownHostException e) {
        } catch (IOException e) {
        }
    }
}
