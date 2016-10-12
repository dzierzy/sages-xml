package pl.com.sages.jprog.calculator;

import java.util.Comparator;

/**
 * Created by marcin on 05.10.2016.
 */
public class ValueComparator implements Comparator<Calculator> {

    @Override
    public int compare(Calculator c1, Calculator c2) {
        double result1 = c1.getResult();
        double result2 = c2.getResult();
        return result1==result2 ? 0 : (result1<result2 ? -1 : 1);
    }
}
