package ch07.sec10.exam01;

public class SmartPhoneExample
{
    public static void main(String[] args) {
        //Phone p = new Phone();  abstract으로 선언된 클래스는 생성 불가

        SmartPhone smartPhone = new SmartPhone("홍길동");

        smartPhone.turnOn(); // 추상화 객체에서 가져온 공통된 특성
        smartPhone.internetSearch();
        smartPhone.turnOff();// 추상화 객체에서 가져온 공통된 특성
    }
}
