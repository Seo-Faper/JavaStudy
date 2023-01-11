package ch05.sec04;

public class GarbageObjectExample {
    public static void main(String[] args) {
        String hobby = "여행";
        hobby = null;

        String kind1 = "자동차";
        String kind2 = kind1; // kind1 변수에 저장되어 있는 주소값을 kind2에 대입

        kind1 = null; // kind1의 주소값을 null로 바꿔서 객체를 지움
        System.out.println("kind2: "+kind2); // 그러나 그 전에 주소값이 대입되어 있기 때문에 "자동차" 출력
    }
}
