package pl.com.sages.jprog.alarm;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Created by marcin on 06.10.2016.
 */
public class ThreadOutput extends PrintStream {

    public ThreadOutput(OutputStream out) {
        super(out);
    }

    @Override
    public void println(String x) {
        super.println(Thread.currentThread().getName() + ": " + x);
    }
}
