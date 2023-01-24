package ch12.homework;

import java.util.Scanner;

public class BOJ_2525 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int M = sc.nextInt();
        int timer = sc.nextInt();

        H += timer / 60;
        M += timer % 60;

        if(M >=60){
            H+=1;
            M-=60;
        }
        if(H >= 24){
            H-=24;
        }
        System.out.println(H+" "+M);
    }
}
