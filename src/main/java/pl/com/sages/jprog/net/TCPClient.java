package pl.com.sages.jprog.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by marcin on 05.10.2016.
 */
public class TCPClient {

    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1", 3000);
            BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String line = null;
            // Wywołanie blokujące (readLine)
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (UnknownHostException e) {
        } catch (IOException e) {
        }
    }
}
