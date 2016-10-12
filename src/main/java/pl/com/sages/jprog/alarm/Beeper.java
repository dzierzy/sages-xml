package pl.com.sages.jprog.alarm;

import java.util.concurrent.ExecutorService;

/**
 * Created by marcin on 06.10.2016.
 */
public class Beeper implements Runnable{

    public void beep(ExecutorService es){

        Runnable r = this;
        //Thread t = new Thread(r, "beeper-thread");
        //t.start();
        es.execute(r);
    }

    @Override
    public void run() {
        for(int i = 0; i < 20; i++){
            System.out.println("beep");

            try {
                Thread.sleep(1*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
