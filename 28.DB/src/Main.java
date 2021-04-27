import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try {
            // загрузили драйвер в виртуальную машину
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }

        // DriverManager - сканирует подключение классы - реализации Driver
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/javaitis13","postgres","sql2021");
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        // интерфейс, объекты которого умеют отправлять в БД
        Statement statement = null;

        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

        ResultSet rows = null;

        try {
            rows = statement.executeQuery("select * from account order by id");
            while (rows.next()) {
                System.out.printf("%5d|%20s|%20s|%30s\n", rows.getInt("id"),
                        rows.getString("first_name"),
                        rows.getString("last_name"),
                        rows.getString("email"));
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

    }
}
