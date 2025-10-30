package modul_6.praktikum_2;

public class Vehicle {
    protected String brand;
    protected int speed;

    // Constructor untuk kelas Vehicle
    public Vehicle(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    // Method yang akan di-override di subclass
    public void start() {
        System.out.println("Vehicle is starting...");
    }

    // Method yang akan di-override di subclass
    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Speed: " + speed + " km/h");
    }
}