import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkWithTab {

    static final String DATABASE_URL = "jdbc:mysql://localhost/newdata";
    static final String USER = "root";
    static final String PASS = "root";

    private static Connection connection;

    //methods for project

    public static void registerPet() throws IOException {

        try (BufferedReader readconcole = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enter the name of your pet");
            String petName = readconcole.readLine();
            System.out.println("Enter the type of your pet");
            String petType = readconcole.readLine();
            System.out.println("Enter the age of your pet");
            int petAge = Integer.parseInt(readconcole.readLine());
            System.out.println("Enter the name of pet parent");
            String petParent = readconcole.readLine();
            System.out.println("Enter the desease of your pet");
            String petDesease = readconcole.readLine();

            Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASS);
            Statement statement = connection.createStatement();
            String petAdding = "insert into newtab1 value\n" +
                    "  (null, '"+ petName + "', '"+petType+"', "+petAge+
                    ", '"+petParent+"', '"+petDesease+"')";
            statement.executeUpdate(petAdding);
            statement.close();
            connection.close();
        } catch (NullPointerException | SQLException ee) {
            ee.printStackTrace();
        }
        System.out.println("your pet is successfully registered");
    }

    public static void allPetsOfClinic() throws SQLException {
        try {
            Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASS);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select id, name, pet, age, parent, desease from newtab1");
            ArrayList<Pets> listOfPets = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString("name");
                String pet = resultSet.getString("pet");
                int age = resultSet.getInt("age");
                String parent = resultSet.getString("parent");
                String desease = resultSet.getString("desease");
                Pets somePet = new Pets(id, name, pet, age, parent, desease);
                listOfPets.add(somePet);
            }
            resultSet.close();
            statement.close();
            connection.close();
            listOfPets.forEach(System.out::println);
        } catch (NullPointerException ee){
            ee.printStackTrace();
        }
    }

    public static void takePet() throws IOException {
        try {
            System.out.println("Enter the name of your pet, please");
            BufferedReader readdd = new BufferedReader(new InputStreamReader(System.in));
            String takenPetname = readdd.readLine();
            Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASS);
            Statement statement = connection.createStatement();
            statement.executeUpdate(
                    "delete from newtab1 where name='" + takenPetname + "';");
            System.out.println("You can take your lovely: "+takenPetname);
            statement.close();
            connection.close();
        } catch (NullPointerException | SQLException ee) {
            ee.printStackTrace();
        }
    }

    public static void healing() {
        System.out.println("what's the name of your pet?");
        try{
            BufferedReader readdd = new BufferedReader(new InputStreamReader(System.in));
            String healingPet = readdd.readLine();
            Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASS);
            Statement statement = connection.createStatement();
            String sqlCommand = "update newtab1 set desease = 'HEALTHY' " +
                    "where name = '" + healingPet + "';";
            statement.executeUpdate(sqlCommand);
            System.out.println("Your pet " +healingPet+ " is healthy. Take it home!");
        } catch (SQLException | IOException e){
            e.printStackTrace();
        }
    }


}
