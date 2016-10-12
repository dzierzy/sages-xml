package pl.com.sages.jprog.calculator;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by marcin on 04.10.2016.
 */
public abstract class Calculator implements Displayable, Comparable{


    List<Double> memory = new ArrayList<>();

    public Calculator(double r){
        memory.add(r);
    }

    public Calculator(){
        memory.add((double)0);
    }

    protected double getLatestFromMemory(){
        return memory.get(memory.size()-1);
    }


    @Override
    public int compareTo(Object o) {

        Calculator other = (Calculator) o;

        int thisSize = this.memory.size();
        int otherSize = other.memory.size();

        return otherSize - thisSize;
    }

    public String getDisplayableValue(){
        double result = getResult();
        //Locale en = new Locale("en");
        Locale en = Locale.ENGLISH;
        NumberFormat nf = NumberFormat.getInstance(en);
        nf.setMinimumFractionDigits(6);
        return nf.format(result);
    }

    public abstract double getResult();

    public void add(double operand){
        double r = getLatestFromMemory() + operand;
        memory.add(r);
    }

    public void substract(double operand){
        double r = getLatestFromMemory() - operand;
        memory.add(r);
    }

    public void multiply(double operand){
        double r = getLatestFromMemory() * operand;
        memory.add(r);
    }

    public void divide(double operand) throws DivideByZeroException {
        if(operand == 0){
            throw new DivideByZeroException("pamietaj cholero nie dziel przez zero");
        }
        double r = getLatestFromMemory() / operand;
        memory.add(r);
    }

    public static int multiply(int x, int y){
        return x * y;
    }

    @Override
    public String toString() {

        boolean first = true;
        StringBuilder present = new StringBuilder("[Calculator, value=" + getResult() + ", ");
        present.append("memory: size=" + memory.size() + ", ");
        present.append("values={");
        for(Double value : memory){
            if(first){
                first = false;
            } else {
                present.append(", ");
            }
            present.append(value);
        }
        present.append("}]");
        return present.toString();
    }
}
