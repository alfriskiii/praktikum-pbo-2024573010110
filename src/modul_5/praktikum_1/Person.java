package praktikum_1;

public class Person {
    //Private - hanya bisa diakses dalam class ini
    private String nama;
    private int umur;

    //Default(package-private)-bisa diakses dalam package yang sama
    public String alamat;

    //protected - bisa diakses dalam package dan subclass
    public String telepon;

    //public - bisa diakses dari mana saja
    public String email;

    //constructor
    public Person(String nama,int umur){
        this.nama= nama;
        this.umur= umur;
    }

    //public method untuk menampilkan info
    public void tampilkanInfo(){
        System.out.println("INFORMASI PERSON");
        System.out.println("Nama     :" + nama);
        System.out.println("Umur     :"  + umur);
        System.out.println("Alamat   :"  + alamat);
        System.out.println("Telepon   :"  + telepon);
        System.out.println("Email      :"  + email);
    }

    //private method - hanya bisa dipanggil dalam class ini
    private void metodePribadi(){
        System.out.println("ini adalah method private");
    }

    //protected method
    protected void metodeProtected(){
        System.out.println("ini adalah method private");
    }

    //method untuk mengakses private method
    public void panggilMetodePribadi(){
        metodePribadi();
    }
}
