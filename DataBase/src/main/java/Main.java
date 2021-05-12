import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","sql2021");
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
