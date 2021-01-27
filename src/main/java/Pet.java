import java.util.Objects;

public class Pet {

    private String name, pet, parent, disease;
    private int age, id;


   public Pet() {
       super();
    }

    public Pet(int id, String name, String pet, int age, String parent, String disease) {
        this.id = id;
        this.name = name;
        this.pet = pet;
        this.age = age;
        this.parent = parent;
        this.disease = disease;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPet() {
        return pet;
    }

    public void setPet(String pet) {
        this.pet = pet;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String desease) {
        this.disease = desease;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pet " + name + " is " + pet + "\n age=" + age +
        "\n disease=" + disease+ "\n parent is " + parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet1 = (Pet) o;
        return age == pet1.age &&
                id == pet1.id &&
                Objects.equals(name, pet1.name) &&
                Objects.equals(pet, pet1.pet) &&
                Objects.equals(parent, pet1.parent) &&
                Objects.equals(disease, pet1.disease);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pet, parent, disease, age, id);
    }
}
