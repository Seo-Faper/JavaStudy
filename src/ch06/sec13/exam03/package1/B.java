package ch06.sec13.exam03.package1;

public class B
{
    public void method(){
        A a = new A();

        a.field1 = 1; // 같은 패키지라 가능
        a.field2 = 2; // 같은 패키지라 가능
        //a.field3 = 3; private라 불가

        a.method1();
        a.method2();
        //a.method3(); private라 불가
    }
}
