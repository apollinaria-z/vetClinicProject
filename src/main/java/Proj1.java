import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.io.IOException;
import java.util.ArrayList;

public class Proj1 {

    private static int petAction;

    public static void main(String[] args) throws SQLException {

          System.out.println("Welcome to the Vet Clinic");
        try (BufferedReader readconcole = new BufferedReader(new InputStreamReader(System.in))) {
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
                      WorkWithTab.registerPet();
                      break;
                  case 0:
                      WorkWithTab.allPetsOfClinic();
                      break;
                  case 2:
                      WorkWithTab.takePet();
                      break;
                  case 3:
                      WorkWithTab.healing();
                      break;
                  case 4:
                      System.out.println("Nice to meet you. See you next time!");
                      break;
              }

         } while (petAction != 4);

        } catch (IOException | SQLException ex) {
            ex.printStackTrace();
        }

        WorkWithTab.connection.close();
}
}