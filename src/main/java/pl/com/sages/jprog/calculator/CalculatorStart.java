package pl.com.sages.jprog.calculator;

import pl.com.sages.jprog.calculator.dao.CalculatorDAO;
import pl.com.sages.jprog.calculator.dao.CalculatorDAOFactory;
import pl.com.sages.jprog.calculator.dao.DAOException;

import java.util.*;

public class CalculatorStart {

    public static void main(String[] args) throws DAOException {

        System.out.println( "starting calculator ..." );

        // prepare display device
        Display display = new Display();

        // obtain or create calculators
        Calculator c1 = getByOwner("Joe");
        Calculator c2 = getByOwner("Jim");
        Calculator c3 = getByOwner("Jack");

        // calculate and display c1
        c1.add(5);
        c1.multiply(3.5);
        try {
            c1.divide(2);
        } catch (DivideByZeroException e) {
            e.printStackTrace();
        }
        display.display( c1 );

        // calculate and display c2
        c2.add(12);
        try {
            c2.divide(3.7);
        } catch (DivideByZeroException e) {
            e.printStackTrace();
        }
        display.display( c2 );

        // calculate and display c3
        c3.add(15);
        try {
            c3.divide(3.7);
        } catch (DivideByZeroException e) {
            e.printStackTrace();
        }
        c3.multiply(2.3);
        c3.multiply(3.3);
        display.display( c3 );

        // create collection in order to sort it
        List<Calculator> calcCollection = new ArrayList<>();
        calcCollection.add(c1);
        calcCollection.add(c2);
        calcCollection.add(c3);

        Collections.sort(calcCollection);
        System.out.println("sort by popularity: " + calcCollection);

        Comparator comparator = new ValueComparator();
        Collections.sort(calcCollection, comparator);
        System.out.println("sort by current value: " + calcCollection);

        // store calculators
        try {
            CalculatorDAO cDao = CalculatorDAOFactory.getCalculatorDAO();
            cDao.save(c1, "Joe");
            cDao.save(c2, "Jim");
            cDao.save(c2, "Jack");
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }


    private static Calculator getByOwner(String ownerName){

        Calculator c = null;
        try {
            CalculatorDAO cDao = CalculatorDAOFactory.getCalculatorDAO();
            c = cDao.findByOwner(ownerName);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        if(c==null){
            c = new ScientificCalculator();
        }
        return c;
    }





}