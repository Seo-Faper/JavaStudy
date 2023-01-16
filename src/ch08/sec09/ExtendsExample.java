package ch08.sec09;

public class ExtendsExample
{
    public static void main(String[] args) {
        InterfaceCImpl impl = new InterfaceCImpl();

        InterfaceA ia = impl;
        ia.methodA();
        //ia.methodB(); InterfaceA와 InterfaceB는 상속관계가 아니므로 불가능

        InterfaceB ib = impl;
        ib.methodB();
        //ia.methodA(); InterfaceA와 InterfaceB는 상속관계가 아니므로 불가능

        InterfaceC ic = impl;
        ic.methodA();
        ic.methodB();
        ic.methodC();
    }
}
