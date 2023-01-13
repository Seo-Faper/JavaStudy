package ch07.sec08.exam02;

public class Driver {
    public void drive(Vehicle vehicle){ //자식 객체가 형 변환되어 들어옴
        vehicle.run(); // 자식 객체가 재정의한 run() 메소드 호출
    }
}
