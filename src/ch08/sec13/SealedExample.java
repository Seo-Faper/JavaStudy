package ch08.sec13;

public class SealedExample
{
    public static void main(String[] args) {
        ImplClass impl = new ImplClass();

        InterfaceA ia = impl;
        ia.methodA();

        InterfaceB ib = impl;
        ib.methodA();
        ib.methodB();

        InterfaceC ic = impl;
        ic.methodA();
        ic.methodB();
        ic.methodC();
    }
}
