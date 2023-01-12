package ch06.sec13.exam03.package2;

import ch06.sec13.exam03.package1.A;

public class C
{
    public C(){
        A a = new A();

        a.field1 = 1; //다른 패키지라도 public은 가능
        //a.field2 = 2; 다른패키지, default라서 접근 불가
        //a.field3 = 3; 다른 패키지, private라서 접근 불가

        a.method1();
        //a.method2(); 다른패키지, default라서 접근 불가
        //a.method3(); 다른 패키지, private라서 접근 불가
    }
}
