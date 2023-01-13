package ch07.sec04.exam02;

public class SupersonicAirplaneExample
{
    public static void main(String[] args) {
        SupersonicAirplane sa = new SupersonicAirplane();
        sa.takeOff();
        sa.fly();
        sa.flayMode = SupersonicAirplane.SUPERSONIC;
        sa.fly();
        sa.flayMode = SupersonicAirplane.NOMAL;
        sa.fly();
        sa.land();
    }
}
