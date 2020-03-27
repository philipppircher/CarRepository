package cc.car.phil;

public class Engine {
    // Constants
    //
    public enum TYPE {GASOLINE, DIESEL}     // set enums always as contants - Engine.TYPE.DIESEL
    private final int FUELCONSUMPTION;

    // Membervariables
    //
    private TYPE type;      // Gasoline or Diesel
    private int horsePower;

    // Constructor
    //
    public Engine(TYPE type, int horsePower, int fuelConsumption) {
        this.type = type;
        this.horsePower = horsePower;
        this.FUELCONSUMPTION = fuelConsumption;
    }

    // Getter
    //
    public int getHorsePower() {
        return horsePower;
    }

    public TYPE getType() {
        return type;
    }

    public int getFUELCONSUMPTION() {
        return FUELCONSUMPTION;
    }
}
