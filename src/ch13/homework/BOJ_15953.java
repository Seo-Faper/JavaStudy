package ch13.homework;

import java.util.Scanner;

public class BOJ_15953 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0; i<n; i++){
            int ans = 0;
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(a==1)
                ans+= 5000000;
            else if(2<=a && a<=3)
                ans+= 3000000;
            else if(4<=a && a<=6)
                ans+= 2000000;
            else if(7<=a && a<=10)
                ans+= 500000;
            else if(11<=a && a<=15)
                ans+= 300000;
            else if(16<=a && a<=21)
                ans+= 100000;
            else
                ans+= 0;

            if(b==1)
                ans+= 5120000;
            else if(2<=b && b<=3)
                ans+= 2560000;
            else if(4<=b && b<=7)
                ans+= 1280000;
            else if(8<=b && b<=15)
                ans+= 640000;
            else if(16<=b && b<=31)
                ans+= 320000;
            System.out.println(ans);
        }
    }
}
