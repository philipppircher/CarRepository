package cc.car.phil;

public class Main {
    public static void main(String[] args) {
        carMethod();
    }

    private static void carMethod(){
        Car c1 = new Car("Audi", "A122", "Blue", 10, 7);
        Car c2 = new Car("VW", "VW1220", "Black", 30, 10);

        Car[] cars = new Car[2];
        cars[0] = c1;
        cars[1] = c2;

        for (int i = 0; i < cars.length; i++) {
            cars[i].printCarData();
            cars[i].drive();
            cars[i].carBreak();
            System.out.println(cars[i].turboBooster());
            int repitition = 2;
            if (i == 1) {
                repitition = 5;
            }
            cars[i].honk(repitition);
            System.out.println();
            System.out.println(cars[i].getBrand() + " verbleibende Strecke zum Fahren: " + cars[i].getRemainingRange());
        }
    }
}
