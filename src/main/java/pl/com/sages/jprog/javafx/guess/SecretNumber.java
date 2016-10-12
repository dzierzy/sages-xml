package pl.com.sages.jprog.javafx.guess;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by marcin on 29.06.2016.
 */
public class SecretNumber {

    private int secret;

    public SecretNumber() {
        reset();
    }

    public void reset(){
        secret = ThreadLocalRandom.current().nextInt(100);
        System.out.println("secret[" + secret +"]");
    }


    public int guess(int guess){
        return secret - guess;
    }
}
