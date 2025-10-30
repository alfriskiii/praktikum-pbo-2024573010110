package modul_6.praktikum_2;

public class OverrideTest {

    public static void main(String[] args) {
        // Membuat objek Car
        Car car = new Car("Toyota", 100, 4);

        System.out.println("** Testing Car object **");

        // Memanggil method yang di-override (versi Car)
        // Output: Vehicle is starting...
        // Output: Car engine is running smoothly
        car.start();

        // Memanggil method yang di-override (versi Car)
        // Output: Brand: Toyota
        // Output: Speed: 100 km/h
        // Output: Number of doors: 4
        car.displayInfo();

        // Memanggil method khusus Car
        // Output: Beep beep!
        car.honk();

        System.out.println("\n** Demonstrasi polymorphism **");

        // Membuat objek Car, namun mereferensikannya dengan tipe Vehicle
        // Ini adalah contoh polymorphism
        Vehicle vehicle = new Car("Honda", 200, 2);

        // Saat dipanggil, Java akan menjalankan method yang di-override dari kelas Car (runtime polymorphism)
        // Output: Vehicle is starting...
        // Output: Car engine is running smoothly
        vehicle.start();

        // Output: Brand: Honda
        // Output: Speed: 200 km/h
        // Output: Number of doors: 2
        vehicle.displayInfo();

        // vehicle.honk(); // TIDAK BISA dipanggil karena referensi 'vehicle' bertipe Vehicle, yang tidak memiliki method honk()
    }
}