package ch06.sec14;

public class CarExample
{
    public static void main(String[] args) {
        Car myCar = new Car();

        myCar.setSpeed(-50); //잘못된 설정
        System.out.println("현재 속도 : "+myCar.getSpeed()); // 0 출력

        myCar.setSpeed(60);
        System.out.println("현재 속도 : "+myCar.getSpeed());

        if(!myCar.isStop()){
            myCar.setStop(true);
        }
        System.out.println("현재 속도 : "+myCar.getSpeed());

    }
}
