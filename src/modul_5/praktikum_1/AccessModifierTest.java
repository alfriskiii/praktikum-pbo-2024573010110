package modul_5.praktikum_1;

import praktikum_1.Person;

public class AccessModifierTest {
    public static void main(String[]args){
        Person Person = new Person("Budi Santoso",25);

        //test akses public
        Person.email = "Budi@gmail.com";
        System.out.println("email:" + Person.email);

        //test akses default(dalam package yang sama)
        Person.alamat="jakarta";                    //ok - dalam package yang sama
        System.out.println("alamat:" + Person.alamat);

        //test akses protected(dalam package yang sama)
        Person.telepon="087837236";                 //ok - dalam package yang sama
        System.out.println("Telepon:" + Person.telepon);

        //test akses private - AKAN ERROR jika uncomment
        //person.nama= "ANDI";              //ERROR - private
        //person.umur= 30;                  //ERROR - private
        //person.metodePribadi();           //ERROR - private

        //mengakses data private melalui public methods
        Person.tampilkanInfo();

        //mengakses private method melalui public method
        Person.panggilMetodePribadi();

        System.out.println("\nDEMONTRASI ACCESS MODIFIER");
        System.out.println("public      : bisa diakses");
        System.out.println("Default     : bisa diakses(dalam package sama)");
        System.out.println("Protected   : bisa diakses(dalam package sama)");
        System.out.println("Private     : Tidak bisa diakses langsung");

    }
}
