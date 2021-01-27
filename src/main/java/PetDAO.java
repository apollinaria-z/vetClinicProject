import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PetDAO{

    private final Connection connection;

    public PetDAO(final Connection connection){
        this.connection = connection;
    }

    public List<Pet> readAllPets() throws SQLException {
        List<Pet> pets = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            String sql = "select * from newtab1";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Pet pet = new Pet(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("pet"),
                        rs.getInt("age"),
                        rs.getString("parent"),
                        rs.getString("disease"));
                    pets.add(pet);
                }
            rs.close();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return pets;

    }
    public Pet showByName(String name) throws SQLException{
        Pet pet = new Pet();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select * from newtab1 where name=(?)");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            pet.setId(resultSet.getInt("id"));
            pet.setName(resultSet.getString("name"));
            pet.setPet(resultSet.getString("pet"));
            pet.setAge(resultSet.getInt("age"));
            pet.setParent(resultSet.getString("parent"));
            pet.setDisease(resultSet.getString("disease"));
            resultSet.close();
            preparedStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return pet;
    }

    public void create(Pet pet) throws SQLException{
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into newtab1 values(DEFAULT,(?),(?),(?),(?),(?))");
            preparedStatement.setString(1, pet.getName());
            preparedStatement.setString(2, pet.getPet());
            preparedStatement.setInt(3, pet.getAge());
            preparedStatement.setString(4, pet.getParent());
            preparedStatement.setString(5, pet.getDisease());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void update(String name, Pet pet) throws SQLException{
        try{
            PreparedStatement preparedStatement =
                    connection.prepareStatement("update newtab1 set pet=(?), age=(?), parent=(?), disease=(?) where name=(?)");
            preparedStatement.setString(1, pet.getPet());
            preparedStatement.setInt(2, pet.getAge());
            preparedStatement.setString(3, pet.getParent());
            preparedStatement.setString(4, pet.getDisease());
            preparedStatement.setString(5, name);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void delete(String name) throws SQLException{
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "delete from newtab1 where name=(?)");
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
