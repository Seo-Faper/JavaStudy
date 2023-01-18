package ch10;

import java.util.Scanner;

public class BOJ_11365 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            String k = sc.nextLine();
            if(k.equals("END"))break;
            for(int i = k.length()-1; i >= 0; i--){
                System.out.print(k.charAt(i));
            }
            System.out.println();
        }
    }
}
