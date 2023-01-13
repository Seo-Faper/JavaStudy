package ch07.sec05.exam02;

public class SportCar extends Car{
    @Override
    public void speedUp() {
        speed +=10;
    }
    @Override
    /*public void stop(){
        오버라이딩 불가
    }*/
}
