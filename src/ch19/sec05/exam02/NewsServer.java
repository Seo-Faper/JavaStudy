package ch19.sec05.exam02;

import java.util.Scanner;

public class NewsServer extends Thread {
    public static void main(String[] args) throws Exception {
        System.out.println("----------------------------------------");
        System.out.println("서버를 종료하려면 q를 입력하고 Enter 키를 입력하세요.");
        System.out.println("----------------------------------------");

        startServer();
        Scanner sc = new Scanner(System.in);
        while (true){
            String key = sc.nextLine();
            if(key.toLowerCase().equals("q")) break;
        }
        sc.close();

        stopServer();
    }

}
