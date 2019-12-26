public class Pets {

    private String name, pet, parent, desease;
    private int age;


   public Pets() {
       this.name = name;
       this.pet = pet;
       this.age = age;
       this.parent = parent;
       this.desease = desease;
    }

    public Pets(String name, String pet, int age, String parent, String desease) {
        this.name = name;
        this.pet = pet;
        this.age = age;
        this.parent = parent;
        this.desease = desease;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesease() {
        return desease;
    }

    public void setDesease(String desease) {
        this.desease = desease;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getPet() {
        return pet;
    }

    public void setPet(String pet) {
        this.pet = pet;
    }
  /*  public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }*/

    @Override
    public String toString() {
        return "Pet " + name + " is " + pet + "\n age=" + age +
        "\n desease=" + desease+ "\n parent is " + parent;
    }
}
