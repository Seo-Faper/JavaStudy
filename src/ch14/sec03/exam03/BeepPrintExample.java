package ch14.sec03.exam03;

import java.awt.*;

public class BeepPrintExample extends Thread{

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                for(int i = 0; i<5; i++){
                    toolkit.beep();
                    try{Thread.sleep(500);} catch (Exception e){}
                }
            }
        });
        thread.start();
    }
}
