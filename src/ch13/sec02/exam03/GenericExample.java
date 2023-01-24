package ch13.sec02.exam03;

public class GenericExample {
    public static void main(String[] args) {
        Box box1 = new Box();
        box1.content = "100";

        Box box2 = new Box();
        box2.content = "100";

        Box box3 = new Box();
        box3.content = 100;

        System.out.println(box1.compare(box2));
        System.out.println(box1.compare(box3));
    }
}
