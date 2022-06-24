package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {
    public void dbInsertion(String tokenName,double deposit, double purchaseP, double currentP
            ,double qttyOfTokens,double depNow,double profit) {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sakila", "", "");

            String sql = "INSERT INTO cryptodata (token_name,deposit,purchase_price" +
                    ",current_price,qntty_orTokens,deposit_now,profit_orLoss)"
                    + " VALUES (?,?,?,?,?,?,?)";

            PreparedStatement preparedStmt = conn.prepareStatement(sql);

            preparedStmt.setString(1,tokenName);
            preparedStmt.setDouble(2,deposit);
            preparedStmt.setDouble(3,purchaseP);
            preparedStmt.setDouble(4,currentP);
            preparedStmt.setDouble(5,qttyOfTokens);
            preparedStmt.setDouble(6,depNow);
            preparedStmt.setDouble(7,profit);


            preparedStmt.execute();

            System.out.println("Signed to db!");
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
