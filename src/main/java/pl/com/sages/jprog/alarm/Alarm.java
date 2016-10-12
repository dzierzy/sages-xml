package pl.com.sages.jprog.alarm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by marcin on 06.10.2016.
 */
public class Alarm {

    public static void main(String[] args) {

        System.setOut(new ThreadOutput(System.out));

        ExecutorService es = Executors.newFixedThreadPool(5);

        Beeper b = new Beeper();
        Light l = new Light();

        b.beep(es);
        l.light(es);

        System.out.println("done.");

        es.shutdown();
    }
}
