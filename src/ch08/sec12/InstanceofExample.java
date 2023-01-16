package ch08.sec12;

public class InstanceofExample {
    public static void main(String[] args) {
        Taxi taxi = new Taxi();
        Bus bus = new Bus();

        ride(taxi);
        ride(bus);

    }
    public static void ride(Vehicle vehicle){
        if(vehicle instanceof Bus bus){
            bus.checkFare();
        }
        vehicle.run();
    }
}
