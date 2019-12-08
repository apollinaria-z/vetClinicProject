import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Proj1 {


    private static final String PATH =
            "jdbc:mysql://127.0.0.1/bh18db?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "rootroot";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        try{
        Connection connection = DriverManager.getConnection(PATH, USER, PASS);
        Statement statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
