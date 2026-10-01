import java.sql.*;

public class Main7TrxManagement {
    private static final String url ="jdbc:mysql://localhost:3306/mydb";
    private static final String username="root";
    private static final String password ="Naman@1234";
    public  static  void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try{

            Connection connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
            String creditQ = "update account set amount =amount- ?  where account_no = ?";
            String debitQ = "update account set amount =amount+ ?  where account_no = ?";
            PreparedStatement preparedStatement1 = connection.prepareStatement(creditQ);
            PreparedStatement preparedStatement2 = connection.prepareStatement(debitQ);
            preparedStatement1.setInt(1,500);
            preparedStatement1.setInt(2, 101);
            preparedStatement2.setInt(2,102);
            preparedStatement2.setInt(1,500);
            int rowsUpdated1  = preparedStatement1.executeUpdate();
            int rowsUpdated2 =preparedStatement2.executeUpdate();
            if (rowsUpdated1 == 1 && rowsUpdated2 == 1) {
                connection.commit();
            } else {
                connection.rollback();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


