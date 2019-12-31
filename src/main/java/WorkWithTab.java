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

   public static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //methods for project

    public static void registerPet() throws IOException {
       Pets newpet = new Pets();

        try  {
            BufferedReader readconcole1 = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the name of your pet");
            newpet.setName(readconcole1.readLine());
            System.out.println("Enter the type of your pet");
            newpet.setPet(readconcole1.readLine());
            System.out.println("Enter the age of your pet");
            newpet.setAge(Integer.parseInt(readconcole1.readLine()));
            System.out.println("Enter the name of pet parent");
            newpet.setParent(readconcole1.readLine());
            System.out.println("Enter the desease of your pet");
            newpet.setDesease(readconcole1.readLine());

           Statement statement = connection.createStatement();
            String petAdding = "insert into newtab1 value\n" +
                    "  (null, '"+ newpet.getName() + "', '"+ newpet.getPet() +"', "+ newpet.getAge() +
                    ", '"+ newpet.getParent() +"', '"+ newpet.getDesease() +"')";
            statement.executeUpdate(petAdding);
            statement.close();
        } catch (NullPointerException | SQLException ee) {
            ee.printStackTrace();
        }
        System.out.println("Dear pet parent! Your pet is successfully registered");
    }

    public static void allPetsOfClinic() throws SQLException {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select id, name, pet, age, parent, desease from newtab1");
            ArrayList<Pets> listOfPets = new ArrayList<>();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String pet = resultSet.getString("pet");
                int age = resultSet.getInt("age");
                String parent = resultSet.getString("parent");
                String desease = resultSet.getString("desease");
                Pets somePet = new Pets(name, pet, age, parent, desease);
                listOfPets.add(somePet);
            }
            resultSet.close();
            statement.close();
            listOfPets.forEach(System.out::println);
            System.out.println("\n Total amount of pets is " + listOfPets.size());
        } catch (NullPointerException ee){
            ee.printStackTrace();
        }
    }

    public static void takePet() throws IOException {
        try {
            System.out.println("Enter the name of your pet, please");
            BufferedReader readdd = new BufferedReader(new InputStreamReader(System.in));
            String takenPetname = readdd.readLine();
           Statement statement = connection.createStatement();
            statement.executeUpdate(
                    "delete from newtab1 where name='" + takenPetname + "';");
            System.out.println("You can take your lovely: "+takenPetname);
           statement.close();
        } catch (NullPointerException | SQLException ee) {
            ee.printStackTrace();
        }
    }

    public static void healing() {
        System.out.println("what's the name of your pet?");
        try{
            BufferedReader readdd1 = new BufferedReader(new InputStreamReader(System.in));
            String healingPet = readdd1.readLine();
            Statement statement = connection.createStatement();
            String sqlCommand = "update newtab1 set desease = 'HEALTHY' " +
                    "where name = '" + healingPet + "';";
            statement.executeUpdate(sqlCommand);
            System.out.println("Your pet " +healingPet+ " is healthy. Take it home!");
            statement.close();
        } catch (SQLException | IOException e){
            e.printStackTrace();
        }
    }

}
