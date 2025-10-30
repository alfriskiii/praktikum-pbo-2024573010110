package modul_6.praktikum_3;

public class Cat extends Mammal {
    private boolean isIndoor;

    // Constructor
    public Cat(String name, String furColor, boolean isIndoor) {
        super(name, furColor); // Memanggil constructor Mammal
        this.isIndoor = isIndoor;
    }

    public void meow() {
        System.out.println(name + " is meowing: Meow meow!");
    }

    // Method Overriding
    @Override
    public void eat() {
        System.out.println(name + " the cat is eating cat food.");
    }
}