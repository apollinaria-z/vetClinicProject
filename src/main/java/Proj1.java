import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.io.IOException;
import java.util.ArrayList;

public class Proj1 extends WorkWithTab {

    public static void main(String[] args) {
    System.out.println("Welcome to the Vet Clinic");
        System.out.println("Select the action from following:" +
                "\n press 0 - if you want to see all pets from our clinic" +
                "\n press 1 - if you want to register your pet in our clinic" +
                "\n press 2 - if you want to take your pet from our clinic" +
                "\n press 3 - if you want to heal your pet" +
                "\n press 4 - if you want to quit");
    try (BufferedReader readconcole = new BufferedReader(new InputStreamReader(System.in))) {
        int petAction = Integer.parseInt(readconcole.readLine());
        switch (petAction){
            case 1:
                registerPet();
                break;
	        case 0:
	            allPetsOfClinic();
                break;
	        case 2:
	            takePet();
                break;
		    case 3:
	            healing();
                break;
            case 4:
                System.out.println("Nice to meet you. See you next time!");
                break;
        }
        System.out.println("SEE YOU!");

    } catch (IOException | SQLException ex) {
        ex.printStackTrace();
    }


    }
}