import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkWithTab {

    static final String DATABASE_URL = "jdbc:mysql://localhost/bh18db";
    static final String USER = "root";
    static final String PASS = "rootroot";

    public static void main(String[] args) {

        try{
            Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASS);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select id, petName from tab1");
          //  List<Pets> listOfPets = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("petName");
            //    listOfPets.add(new Pets(id, name));
                System.out.println("id: " + id);
                System.out.println("Name: " + name);
            }

            statement.close();
            connection.close();

          //  listOfPets.forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

   /*

    while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
   */
}
