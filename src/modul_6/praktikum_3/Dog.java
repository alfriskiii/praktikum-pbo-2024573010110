package modul_6.praktikum_3;

public class Dog extends Mammal {
    private String breed;

    // Constructor
    public Dog(String name, String furColor, String breed) {
        super(name, furColor); // Memanggil constructor Mammal
        this.breed = breed;
    }

    public void bark() {
        System.out.println(name + " is barking: Woof woof!");
    }

    // Method Overriding
    @Override
    public void eat() {
        System.out.println(name + " the dog is eating dog food.");
    }
}