package pl.com.sages.jprog.calculator;

/**
 * Created by marcin on 04.10.2016.
 */
public class ScientificCalculator extends Calculator {

    public ScientificCalculator(){
    }

    public ScientificCalculator(double d){
        super(d);
    }

    public double getResult(){
        return getLatestFromMemory();
    }


    public void mod(double operand){
        double r = getLatestFromMemory() % operand;
        memory.add(r);
    }

    public void div(double operand){
        double r = (int)(getLatestFromMemory() / operand);
        memory.add(r);
    }


}
