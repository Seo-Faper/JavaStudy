package ch09.sec05.exam01;

public class A {
    int field1;
    void method1(){}
    static int field2;
    static void method2(){}

    class B{
        void method(){
            field1 = 10;
            method1();

            field2 = 10;
            method2();
        }
    }
    static class C{
        void method(){
            //field1 = 10; 정적 멤버에서는 바깥 객체가 없어도 사용가능해야 하므로 사용 불가
            //method1();

            //static으로 선언된 필드와 메소드는 가능
            field2 = 10;
            method2();;
        }
    }
}
