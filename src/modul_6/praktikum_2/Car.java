package modul_6.praktikum_2;

public class Car extends Vehicle {
    private int numberOfDoors;

    // Constructor untuk kelas Car
    public Car(String brand, int speed, int numberOfDoors) {
        // Memanggil constructor superclass (Vehicle)
        super(brand, speed);
        this.numberOfDoors = numberOfDoors;
    }

    // Mengganti (Override) method start() dari superclass
    @Override
    public void start() {
        // Memanggil method start dari superclass
        super.start();
        System.out.println("Car engine is running smoothly");
    }

    // Mengganti (Override) method displayInfo() dari superclass
    @Override
    public void displayInfo() {
        // Memanggil method displayInfo dari superclass
        super.displayInfo();
        System.out.println("Number of doors: " + numberOfDoors);
    }

    // Method khusus untuk kelas Car
    public void honk() {
        System.out.println("Beep beep!");
    }
}