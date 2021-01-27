import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.io.IOException;
import java.util.ArrayList;

public class RunThis {

    private static int petAction;
    public static final String URL = "jdbc:postgresql://localhost:5432/petclinicdb";
    public static final String USER = "postgres";
    public static final String PASSWORD = "postgres";

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        PetDAO petDAO;

        System.out.println("Welcome to the Vet Clinic");

            try{
                Class.forName("org.postgresql.Driver");
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }
            try {
                connection = DriverManager.getConnection(URL,USER,PASSWORD);
                petDAO = new PetDAO(connection);
                PetService petService = new PetService(petDAO);
                BufferedReader readconcole = new BufferedReader(new InputStreamReader(System.in));
                do {
                    System.out.println("\n Select the action from following:" +
                            "\n press 0 - if you want to see all pets from our clinic" +
                            "\n press 1 - if you want to register your pet in our clinic" +
                            "\n press 2 - if you want to take your pet from our clinic" +
                            "\n press 3 - if you want to heal your pet" +
                            "\n press 4 - if you want to quit");
                    petAction = Integer.parseInt(readconcole.readLine());
                    switch (petAction) {
                        case 1:
                            petService.registerPet();
                            break;
                        case 0:
                            petService.showPetList();
                            break;
                        case 2:
                            petService.takePetHome();
                            break;
                        case 3:
                            petService.healingPet();
                            break;
                        case 4:
                            System.out.println("Nice to meet you. See you next time!");
                            break;
                    }
                } while (petAction != 4);

            } catch (SQLException | IOException throwables) {
                throwables.printStackTrace();
            }finally {
                connection.close();
            }


}
}