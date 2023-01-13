package ch07.sec07.exam02;

public class ChildExample
{
    public static void main(String[] args) {

        Child child = new Child();

        Parent parent = child; // 자동 형 변환

        parent.method1();
        parent.method2();
        //parent.method3(); 불가능
    }
}
