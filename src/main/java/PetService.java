import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PetService {

    private PetDAO petDAO;

    public PetService(PetDAO petDAO) {
        this.petDAO = petDAO;
    }

    public void registerPet() throws SQLException {
        Pet newpet = new Pet();
        try {
            BufferedReader readconcole1 = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the name of your pet");
            newpet.setName(readconcole1.readLine());
            System.out.println("Enter the type of your pet");
            newpet.setPet(readconcole1.readLine());
            System.out.println("Enter the age of your pet");
            newpet.setAge(Integer.parseInt(readconcole1.readLine()));
            System.out.println("Enter the name of pet parent");
            newpet.setParent(readconcole1.readLine());
            System.out.println("Enter the disease of your pet");
            newpet.setDisease(readconcole1.readLine());
            petDAO.create(newpet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Dear pet parent! Your pet is successfully registered");
    }

    public void showPetList() throws SQLException {
        List<Pet> petList = new ArrayList<>();
        petList = petDAO.readAllPets();
        petList.forEach(System.out::println);
    }

    public void takePetHome() {
        try {
            System.out.println("Enter the name of your pet, please");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String petNameToTake = reader.readLine();
            petDAO.delete(petNameToTake);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void healingPet() {
        System.out.println("what's the name of your pet?");
        try {
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
            String healingPet = reader1.readLine();
            Pet pet = new Pet();
            pet = petDAO.showByName(healingPet);
            pet.setDisease("NO diseases");
            petDAO.update(healingPet, pet);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

    }
}
