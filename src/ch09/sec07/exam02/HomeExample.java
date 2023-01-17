package ch09.sec07.exam02;

public class HomeExample {
    public static void main(String[] args) {
        Home home = new Home(); //Home 객체 생성

        //익명 구현 객체가 대입된 필드 사용
        home.use1();

        //익명 구현 객체가 대입된 로컬 변수 사용
        home.use2();

        // 익명 구현 객체가 대입된 매개변수 사용
        home.use3(new RemoteControl() {
            @Override
            public void turnOn() {
                System.out.println("난방을 킵니다.");
            }

            @Override
            public void turnOff() {
                System.out.println("난방을 끕니다.");
            }
        });
    }
}
