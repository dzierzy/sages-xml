package pl.com.sages.jprog.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Created by marcin on 12.10.2016.
 */
public class MessageReader implements Runnable {

    private BufferedReader reader;

    public MessageReader(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public void run() {
        String received = null;
        try {
            while((received = reader.readLine())!=null && !"quit".equals(received)){
                System.out.println(received);
            }
        } catch (IOException e) {
        } finally {
            System.out.println("<< disconnected >>");
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
