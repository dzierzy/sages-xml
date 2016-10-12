package pl.com.sages.jprog.alarm;

import java.util.concurrent.ExecutorService;

/**
 * Created by marcin on 06.10.2016.
 */
public class Light implements Runnable{

    public void light(ExecutorService es){

        Runnable r = this;
        //Thread t = new Thread(r, "light-thread");
        //t.start();

        es.execute(r);
    }

    @Override
    public void run() {
        for(int i = 0; i<15; i++){
            System.out.println("flash");

            try {
                Thread.sleep(2*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
