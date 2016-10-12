package pl.com.sages.jprog.calculator;

/**
 * Created by marcin on 04.10.2016.
 */
public class DivideByZeroException extends Exception{

    public DivideByZeroException(String message) {
        super(message);
    }
}
