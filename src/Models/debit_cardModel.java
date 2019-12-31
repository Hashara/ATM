package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Objects.ATMCard;
import DB.Database;


public class debit_cardModel {

    private Connection connection;

    //check card number is valid and is not expired
    public String IsCardNumberValid(ATMCard atm){
        connection = DB.Database.getConnection();
        String result = "Error! Try again.";
        try {
            String sql = "CALL `CheckCardNumberIsValid`(?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,atm.getCardNumber());

            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                result = rs.getString(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
}
