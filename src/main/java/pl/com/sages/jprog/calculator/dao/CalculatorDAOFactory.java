package pl.com.sages.jprog.calculator.dao;

/**
 * Created by marcin on 05.10.2016.
 */
public class CalculatorDAOFactory {

    private static CalculatorDAO cDao;

    public static CalculatorDAO getCalculatorDAO() throws DAOException {
        if(cDao==null){
            cDao = new FileCalculatorDAO();
        }
        return cDao;
    }
}
