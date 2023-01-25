package ch13.homework;

import java.util.Scanner;

public class BOJ_15667 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1; i<=n; i++){
            if(i*i + i + 1 - n == 0){
                System.out.println(i);
                break;
            }
        }
    }
}
