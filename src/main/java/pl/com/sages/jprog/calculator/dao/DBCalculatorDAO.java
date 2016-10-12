package pl.com.sages.jprog.calculator.dao;

import pl.com.sages.jprog.calculator.Calculator;
import pl.com.sages.jprog.calculator.ScientificCalculator;

import java.sql.*;

/**
 * Created by marcin on 06.10.2016.
 */
public class DBCalculatorDAO implements CalculatorDAO {


    public DBCalculatorDAO() throws DAOException {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new DAOException("problem while loading driver", e);
        }
    }




    @Override
    public void save(Calculator c, String owner) throws DAOException {

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
            Statement s = connection.createStatement();
            int count = s.executeUpdate(
                    "insert into calculator (owner, value) values ('" + owner + "', " + c.getDisplayableValue() +")");

            System.out.println("sucessfuly saved data. rows modified: " + count);

            connection.close();
        } catch (SQLException e) {
            throw new DAOException("problem while saving data", e);
        }

    }

    @Override
    public Calculator findByOwner(String owner) throws DAOException {
        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
            PreparedStatement s = connection.prepareStatement("select value from calculator where owner=?");
            s.setString(1, owner);

            ResultSet rs = s.executeQuery();

            if(rs.next()){
                double value = rs.getDouble("value");
                Calculator c = new ScientificCalculator(value);
                return c;
            }



            connection.close();
        } catch (SQLException e) {
            throw new DAOException("problem while saving data", e);
        }
        return null;
    }
}
