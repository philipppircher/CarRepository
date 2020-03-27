package cc.car.phil;

public class Tank {
    // Constants
    //
    public double MAXTANK;

    // Membervariables
    //
    private double fuelInLiter;

    // Constructor
    //
    public Tank(double maxTank) {
        this.MAXTANK = maxTank;
    }

    // Getter - Setter
    //
    public void setFuelInLiter(double fuelInLiter) {
        this.fuelInLiter = fuelInLiter;
    }

    public double getFuelInLiter() {
        return fuelInLiter;
    }
}
