import java.sql.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    //fix steps to connect
    private static final String url ="jdbc:mysql://localhost:3306/mydb";
    private static final String username="root";
    private static final String password ="Naman@1234";
    public static void main(String[] args) throws ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        // com.mysql.cj package ke anadar pade hai drivers jo help karege drivers connect karne mai
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement   = connection.createStatement();
            //statement interface ka use karke
            String query = "select * from student";
            ResultSet resultSet = statement.executeQuery(query); //retrive
//          statement.executeUpdate()//data ko update , insert ,update ,delete
            while (resultSet.next()){
               int id = resultSet.getInt("id");
               int age = resultSet.getInt("age");
               double marks = resultSet.getDouble("marks");
               String name = resultSet.getString("name");
               System.out.println("id: "+id +" name :"+name+" age : "+age+" marks : "+marks);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}