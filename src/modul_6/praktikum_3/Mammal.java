package modul_6.praktikum_3;

public class Mammal extends Animal {
    protected String furColor;

    // Constructor
    public Mammal(String name, String furColor) {
        super(name); // Memanggil constructor Animal
        this.furColor = furColor;
    }

    public void giveBirth() {
        System.out.println(name + " is giving birth to live young.");
    }
}