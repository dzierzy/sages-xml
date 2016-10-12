package pl.com.sages.jprog.calculator;

/**
 * Display device which an present value
 * @author me
 * Created by marcin on 04.10.2016.
 */
public class Display {

    /**
     * Displays value
     * @param d provider of value to dislay
     */
    public void display(Displayable d){
        String value = d.getDisplayableValue();
        //System.out.println("*** " + value + " ***");
        //System.out.printf("[%1$20s]\n", value);
        System.out.printf("%2$s%1$20s%3$s\n", value, "[", "]");
    }
}
