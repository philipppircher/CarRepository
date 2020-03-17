package cc.car.phil;

public class Car {
    // Membervariables
    //
    private final int FUELCONSUMPTION = 7;
    private int fuelAmount;
    private String brand, serialNumber, color;
    private final int MAXFUELL = 50;
    private int remainingRange;

    // Constructor
    //
    public Car(String brand, String serialNumber, String color, int fuelAmount, int fuelConsumption) {
        this.brand = brand;
        this.serialNumber = serialNumber;
        this.color = color;
        this.fuelAmount = fuelAmount;

        if (fuelAmount < MAXFUELL) {
            this.fuelAmount = fuelAmount;
        } else {
            this.fuelAmount = MAXFUELL;
        }
    }

    // Methodes (only Getter because Variables only set in Class
    //

    public String getBrand() {
        return brand;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getColor() {
        return color;
    }

    public int getFuelAmount() {
        return fuelAmount;
    }

    public int getFuelConsumption() {
        return FUELCONSUMPTION;
    }

    public void drive(){
        fuelAmount -= FUELCONSUMPTION;
        System.out.println("I'm driving " + getBrand());
        System.out.println("Current fuelAmount after driving: " + getFuelAmount());
    }

    public void printCarData(){
        System.out.println("\nMarke: " + getBrand());
        System.out.println("Serialnummer: " + getSerialNumber());
        System.out.println("Farbe " + getColor());
        System.out.println("Maximaler Tank in Liter : " + MAXFUELL);
        System.out.println("Momentaner Kraftstoff in Liter: " + getFuelAmount());
        System.out.println("Verbraucht Liter/Fahrt: " + getFuelConsumption());
        System.out.println();
    }

    public String carBreak(){
        return "Ich bremse";
    }

    public String turboBooster(){
        String turboBoosterModeText;
        turboBoosterModeText = getFuelAmount() >= MAXFUELL * 0.1
                ? "SuperBoosterMode" : "Not enough fuel to got to SuperBoosterMode";
        return turboBoosterModeText;
    }

    public void honk(int amountOfRepetitions){
        for (int i = 0; i < amountOfRepetitions; i++) {
            System.out.println("huuup");
        }
    }

    public int getRemainingRange(){
        return fuelAmount * FUELCONSUMPTION;
    }
}
