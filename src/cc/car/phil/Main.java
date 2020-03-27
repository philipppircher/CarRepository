package cc.car.phil;

public class Main {
    public static void main(String[] args) {
        initalizeTwoCarsAndPrintData();
    }

    private static void initalizeTwoCarsAndPrintData() {
        Engine e1 = new Engine(Engine.TYPE.GASOLINE, 100, 5);
        Engine e2 = new Engine(Engine.TYPE.DIESEL, 200, 10);
        Tank tank1 = new Tank(50);
        Tank tank2 = new Tank(40);
        Tire[] tiresforC1 = new Tire[4];
        Tire[] tiresforC2 = new Tire[4];
        Tire.BRAND tireBrandForC1 = Tire.BRAND.Continental;
        Tire.BRAND tireBrandForC2 = Tire.BRAND.Dunlop;
        DrivingMirror[] mirrorsC1 = getDrivingMirrors(30, 100);
        DrivingMirror[] mirrorsC2 = getDrivingMirrors(60, 73);

        setTireArray(tiresforC1, tireBrandForC1);
        setTireArray(tiresforC2, tireBrandForC2);

        Car c1 = new Car(e1, tank1, "VW1220", 50,
                200, Car.COLORTYP.Schwarz, Car.BRAND.VW, tiresforC1, mirrorsC1);
        Car c2 = new Car(e2, tank2, "M0999", 30,
                100, Car.COLORTYP.Schwarz, Car.BRAND.Mercedes, tiresforC2, mirrorsC2);

        Car[] cars = {c1, c2};
        printCarFullFunctionOutput(cars);
    }

    private static void setTireArray(Tire[] tires, Tire.BRAND brand) {
        for (int i = 0; i < tires.length; i++) {
            tires[i] = new Tire(brand);
        }
    }

    private static DrivingMirror[] getDrivingMirrors(int positionLeftMirror, int positionRightMirror) {
        DrivingMirror[] mirrors = new DrivingMirror[2];
        mirrors[0] = new DrivingMirror(positionLeftMirror);
        mirrors[1] = new DrivingMirror(positionRightMirror);
        return mirrors;
    }

    private static void printCarFullFunctionOutput(Car[] cars) {
        for (int i = 0; i < cars.length; i++) {
            cars[i].printCarData();
            cars[i].drive(50);
            cars[i].carBreak();
            System.out.println(cars[i].turboBooster());
            System.out.println("Linker Spiegel Position: " + cars[i].mirrors[0].getPosition());
            System.out.println("Rechter Spiegel Positon: " + cars[i].mirrors[1].getPosition());
            cars[i].honk(4);
            System.out.println();
            System.out.println(cars[i].getBrand() + " verbleibende Strecke zum Fahren: " + cars[i].getRemainingRange());

            int currentSpeed = 100;
            cars[i].drive(currentSpeed);
            System.out.println("Momentane km/h: " + cars[i].getCurrentSpeed());
            cars[i].carBreak();
            System.out.println
                    ("Gebremst mit " + cars[i].getTires().length + " Reifen von " + cars[i].getTires()[1].brand);
            System.out.println("-------------------------------------------------------------------");
        }
    }
}
