import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        Vehicle[] vs = new Vehicle[c];
        for (int i = 0; i < c; i++) {
            int type = sc.nextInt();
            Vehicle v = null;
            if (type == 1) {// 货车
                vs[i] = new Truck(sc.nextDouble());
            } else if (type == 2) {
                vs[i] = new Keche(sc.nextInt());
            } else if (type == 3) {
                vs[i] = new Car(sc.nextInt(), sc.nextInt());
            }
        }

        System.out.printf("%.2f", CarRentCompany.rentVehicles(vs));

    }
}

/* 你的代码被嵌在这里 */

interface Vehicle {
    double cost();
}

class Truck implements Vehicle {
    double load;

    Truck(double load) {
        this.load = load;
    }

    public double cost() {
        return load * 1000;
    }
}

class Keche implements Vehicle {
    int seats;

    Keche(int seats) {
        this.seats = seats;
    }

    public double cost() {
        return seats * 50;
    }
}

class Car implements Vehicle {
    int level, year;

    Car(int level, int year) {
        this.level = level;
        this.year = year;
    }

    public double cost() {
        return 200 * level / Math.sqrt(year);
    }
}

class CarRentCompany {
    static double rentVehicles(Vehicle[] vs) {
        double total = 0;
        for (Vehicle v : vs)
            total += v.cost();
        return total;
    }
}