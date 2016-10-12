package pl.com.sages.jprog.calculator.dao;

import pl.com.sages.jprog.calculator.Calculator;

/**
 * Created by marcin on 05.10.2016.
 */
public interface CalculatorDAO {

    void save(Calculator c, String owner) throws DAOException;

    Calculator findByOwner(String owner) throws DAOException;

}
