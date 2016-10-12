package pl.com.sages.jprog.calculator.dao;

import pl.com.sages.jprog.calculator.Calculator;
import pl.com.sages.jprog.calculator.ScientificCalculator;

import java.io.*;

/**
 * Created by marcin on 05.10.2016.
 */
public class FileCalculatorDAO implements CalculatorDAO {

    @Override
    public void save(Calculator c, String owner) throws DAOException {

        File file = new File(owner + ".calc");

        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new DAOException("problem while creating file for owner " + owner, e);
            }
        }

        try(Writer w = new FileWriter(file)) {
            w.write("" + c.getResult());
        } catch (IOException e) {
            throw new DAOException("problem while working with writer", e);
        }

    }

    @Override
    public Calculator findByOwner(String owner) throws DAOException {

        File file = new File(owner + ".calc");

        try(BufferedReader r = new BufferedReader(new FileReader(file))){
            String line = r.readLine();
            double d = Double.parseDouble(line);
            Calculator c = new ScientificCalculator(d);
            return c;

        } catch (Exception e) {
            throw new DAOException("problem while reading value", e);
        }


    }
}
