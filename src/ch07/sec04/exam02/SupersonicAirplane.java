package ch07.sec04.exam02;

public class SupersonicAirplane extends Airplane
{
    public static final int NOMAL = 1;
    public static final int SUPERSONIC = 2;

    public int flayMode = NOMAL;

    @Override
    public void fly() {
        if(flayMode == SUPERSONIC){
            System.out.println("초음속 비행합니다.");
        }else{
            super.fly();
        }
    }
}
