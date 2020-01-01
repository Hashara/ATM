package Models;

import Objects.WithdrawObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class atm_withdrawModel {
    private Connection connection;

    public String WithdrawMoney(WithdrawObject withdrawObject){

        connection = DB.Database.getConnection();
        String result = "Error! Try again.";
//        System.out.println("hi");
        try {
            String sql = "CALL `Withdraw`(?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
//            stmt.setString(1,atm.getCardNumber());

            stmt.setString(1,withdrawObject.getCardNumber());
            stmt.setString(2,withdrawObject.getAmount());

//            System.out.println(stmt);

            if (withdrawObject.getAmount().isEmpty()==false) {
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    result = rs.getString(1);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;


    }
}
