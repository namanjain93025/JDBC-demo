import java.sql.*;
import java.util.Scanner;

public class Main7BathProcessingUsingP {
    private static final String url ="jdbc:mysql://localhost:3306/mydb";
    private static final String username="root";
    private static final String password ="Naman@1234";
    public static void main(String[]args)  {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection connection = DriverManager.getConnection(url, username, password);
            Scanner scanner = new Scanner(System.in);
            String query = String.format("insert into student (name,age,marks) values(?,?,?)");
            PreparedStatement preparedStatement = connection.prepareStatement(query);;
            while (true){
                System.out.println("Enter Name : ");
                String name = scanner.next();
                System.out.println("Enter age : ");
                int age = scanner.nextInt();
                System.out.println("Enter Marks : ");
                double marks = scanner.nextDouble();
                System.out.println("Enter more data (y/n) : ");
                String choice = scanner.next();
                preparedStatement.setInt(2,age);
                preparedStatement.setDouble(3,marks);
                preparedStatement.setString(1,name);
                preparedStatement.addBatch();

                if(choice.toLowerCase().equals("n"))break;
            }

            int[] arr = preparedStatement.executeBatch();
            //arr = [0,1,1,1,0,0]
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
