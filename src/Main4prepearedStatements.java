import java.sql.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main4prepearedStatements {
    //fix steps to connect
    private static final String url ="jdbc:mysql://localhost:3306/mydb";
    private static final String username="root";
    private static final String password ="Naman@1234";
    public static void main(String[] args) throws ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        // com.mysql.cj package ke anadar pade hai drivers jo help karege drivers connect karne mai
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            String q = "Insert into student (name ,age ,marks) values(?,?,?)";

            PreparedStatement preparedStatement   = connection.prepareStatement(q);
            preparedStatement.setString(1,"Ankita");
            preparedStatement.setInt(2,24);
            preparedStatement.setDouble(3,89.2);
            int t=  preparedStatement.executeUpdate();//data ko update , insert ,update ,delete
            if(t>0){
                System.out.println("Changes are dome");
            }else{
                System.out.println("No changes are made");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}