package pl.com.sages.jprog.xml.dom;

import org.junit.Assert;
import org.junit.Test;
import pl.com.sages.jprog.calculator.Calculator;
import pl.com.sages.jprog.calculator.ScientificCalculator;

/**
 * Created by marcin on 06.10.2016.
 */
public class CalculatorTest {

    @Test
    public void testAddOperation(){

        Calculator c = new ScientificCalculator(2.0);
        c.add(3.0);

        Assert.assertEquals("2+3!=5", 4.0, c.getResult(), 0);
    }

    @Test
    public void testDivOperation(){

        ScientificCalculator c = new ScientificCalculator(2.0);
        c.div(3.0);

        Assert.assertEquals("result is not integer!", (int) c.getResult(), c.getResult(), 0);
    }


}
