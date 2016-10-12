package pl.com.sages.jprog.net;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by marcin on 12.10.2016.
 */
public class MessageWriter implements Runnable {

    private PrintWriter writer;

    public MessageWriter(PrintWriter writer) {
        this.writer = writer;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String msg = "";
        while(!"quit".equalsIgnoreCase(msg)){
            msg=scanner.nextLine();
            writer.println(msg);
            writer.flush();
        }
        System.out.println("exiting...");
        writer.close();
    }
}
