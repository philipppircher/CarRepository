package cc.car.phil;

public class Tire {
    // Constants
    //
    public enum BRAND {Michelin, Dunlop, Continental}

    // Membervariables
    //
    public BRAND brand;

    // Constructor
    //
    public Tire(BRAND brand) {
        this.brand = brand;
    }
}
