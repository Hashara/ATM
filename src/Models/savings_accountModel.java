package Models;

import Objects.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class savings_accountModel {

    private Connection connection;

    public String getBalance(Account account){
        connection = DB.Database.getConnection();
        String result = "Error! Try again.";
        try {
            String sql = "SELECT `Balance` FROM `savings_account` WHERE `AccountNumber`=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,account.getAccountNum());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                result = rs.getString(1);
//                atm.setAccountNumber(result);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
}
