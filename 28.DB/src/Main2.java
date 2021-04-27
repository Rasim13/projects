import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) throws Exception{
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/javaitis13","postgres","sql2021");
        Scanner scanner = new Scanner(System.in);
        String carColor = scanner.nextLine();
//        String sql = "insert into car(color) values('" + carColor + "');";
//        System.out.println(sql);
//        connection.createStatement().executeUpdate(sql);
        PreparedStatement preparedStatement = connection.prepareStatement("insert into car (color) values (?);");
        preparedStatement.setString(1, carColor);
        preparedStatement.executeUpdate();

    }
}
