package modul_6.praktikum_3;

import java.util.ArrayList;
import java.util.List;

public class InheritanceTypeTest {

    public static void main(String[] args) {

        // Multilevel inheritance test
        System.out.println(">> Multilevel inheritance test (Dog)");
        Dog dog = new Dog("Buddy", "Brown", "Golden Retriever");

        // Method dari Animal (level 1)
        dog.sleep();

        // Method eat yang di-override (versi Dog)
        dog.eat();

        // Method dari Mammal (level 2)
        dog.giveBirth();

        // Method dari Dog (level 3)
        dog.bark();

        System.out.println("\n>> Hierarchical inheritance test (Cat)");

        // Hierarchical inheritance test
        Cat cat = new Cat("Whiskers", "White", true);

        // Method dari Animal (level 1)
        cat.sleep();

        // Method eat yang di-override (versi Cat)
        cat.eat();

        // Method dari Mammal (level 2)
        cat.giveBirth();

        // Method dari Cat (level 3)
        cat.meow();

        System.out.println("\n>> Demonstrasi Polymorphism");

        // Polymorphism (List of Animal references holding Dog and Cat objects)
        List<Animal> animals = new ArrayList<>();
        animals.add(new Dog("Max", "Black", "Labrador"));
        animals.add(new Cat("Luna", "Gray", false));

        for (Animal animal : animals) {
            // Memanggil method 'eat()' yang sesuai dengan objek sebenarnya (runtime polymorphism)
            animal.eat();
        }
    }
}