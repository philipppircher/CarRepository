package cc.car.phil;

public class Car {
    // Constants
    //
    // Set enum to public to get access outside
    public enum COLORTYP {Schwarz, Weiss, Blau, Grün, Gelb, Rot}

    public enum BRAND {Mercedes, Audi, Fiat, VW}

    private final int SPEEDMIN = 10;
    private final int SPEEDMAX;


    // Membervariables
    //
    private int fuelAmountDisplay;                 // Tankstand Anzeige
    private String serialNumber;
    private Engine engine;
    private Tank tank;
    private int currentSpeed;
    private final int SCALEMAX = 100;
    private int scale;
    private Tire[] tires;
    public DrivingMirror[] mirrors;
    private COLORTYP color;
    private BRAND brand;

    // Constructor
    //
    public Car
    (Engine engine, Tank tank, String serialNumber, int fuelAmount, int speedMax,
     COLORTYP color, BRAND brand, Tire[] tires, DrivingMirror[] mirrors) {
        this.engine = engine;
        this.tank = tank;
        this.brand = brand;
        this.serialNumber = serialNumber;
        this.color = color;
        this.SPEEDMAX = speedMax;
        this.fuelAmountDisplay = fuelAmount;    // Display of car show liters
        this.tank.MAXTANK = fuelAmount;         // Set tank.maxTank to given parameter fuelAmount
        this.tank.setFuelInLiter(fuelAmount);   // Set tank.fuel to fuelAmount
        this.tires = tires;
        this.mirrors = mirrors;
    }

    // Methodes
    //
    public void drive(final int speed) {
        if (this.tank.getFuelInLiter() >= engine.getFUELCONSUMPTION()) {
            setCurrentSpeed(speed);
            fuelAmountDisplay -= engine.getFUELCONSUMPTION();
            System.out.println("The motor is running with " + getCurrentSpeed() + "km/h");
            System.out.println("Current fuelAmount after driving: " + getFuelAmountDisplay());
        } else {
            System.out.println("Zu wenig Treibstoff");
        }
    }

    private void setCurrentSpeed(final int speed) {
        if (speed >= this.SPEEDMIN && speed <= this.SPEEDMAX) {
            this.currentSpeed = speed;
            getScale();
        } else if (speed < this.SPEEDMIN) {
            this.currentSpeed = this.SPEEDMIN;
        } else if (speed > this.SPEEDMAX) {
            this.currentSpeed = this.SPEEDMAX;
        }
    }

    private void calculateScale() {
        scale = SCALEMAX * currentSpeed / this.SPEEDMAX;        // 200 speed / 100 scalemax = 1%
        System.out.println("Skala " + scale + "% von maximal " + SCALEMAX + "% erreicht");
        System.out.println(currentSpeed + " km/h von maximal " + this.SCALEMAX + "km/h erreicht\n");
    }

    public void printCarData() {
        System.out.println("Technisches Merkblatt:");
        System.out.println("\nMarke: " + getBrand());
        System.out.println("Serialnummer: " + getSerialNumber());
        System.out.println("Farbe " + getColor());
        System.out.println("Maximaler Tank in Liter : " + tank.MAXTANK);
        System.out.println("Momentaner Kraftstoff in Liter: " + getFuelAmountDisplay());
        System.out.println("Verbraucht Liter/Fahrt: " + engine.getFUELCONSUMPTION());
        System.out.println("PS: " + engine.getHorsePower());
        System.out.println("Kraftstoff: " + engine.getType() + "\n");
    }

    public void carBreak() {
        System.out.println("Bremse gedrückt..");
        System.out.println(currentSpeed + "km/h");
        do {
            currentSpeed -= 10;
            System.out.println(currentSpeed + "km/h");
        } while (currentSpeed > 0);
        System.out.println("Auto Stillstand\n");
    }

    public String turboBooster() {
        String turboBoosterModeText = getFuelAmountDisplay() >= tank.MAXTANK * 0.1
                ? "SuperBoosterMode" : "Not enough fuel to use SuperBoosterMode\n";
        return turboBoosterModeText;
    }

    public void honk(int amountOfRepetitions) {
        for (int i = 0; i < amountOfRepetitions; i++) {
            System.out.println("huuup");
            if (i == amountOfRepetitions - 1)
                System.out.println("Ich bin ein " + getBrand() + " , habe die Farbe " + getColor() + " und habe "
                        + engine.getHorsePower() + "PS");
        }
    }

    public int getRemainingRange() {
        return fuelAmountDisplay * engine.getFUELCONSUMPTION();
    }

    // Getter - Setter
    //
    public int getScale() {
        calculateScale();
        return scale;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public BRAND getBrand() {
        return brand;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public COLORTYP getColor() {
        return color;
    }

    public int getFuelAmountDisplay() {
        return fuelAmountDisplay;
    }

    public Tire[] getTires() {
        return tires;
    }
}
