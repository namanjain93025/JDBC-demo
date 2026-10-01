import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main6BatchProcessing {
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
            Statement statement = connection.createStatement();;
            while (true){
                System.out.println("Enter Name : ");
                String name = scanner.next();
                System.out.println("Enter age : ");
                int age = scanner.nextInt();
                System.out.println("Enter Marks : ");
                double marks = scanner.nextDouble();
                System.out.println("Enter more data (y/n) : ");
                String choice = scanner.next();
                String query = String.format("insert into student (name,age,marks) values('%s',%d,%f)", name,age,marks);

                statement.addBatch(query);

                if(choice.toLowerCase().equals("n"))break;
            }

            int[] arr = statement.executeBatch();
            //arr = [0,1,1,1,0,0]
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
