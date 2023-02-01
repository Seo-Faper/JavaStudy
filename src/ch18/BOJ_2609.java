package ch18;

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ_2609 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(gcd(a,b));
        System.out.println(lcm(a,b));
    }
    private static int gcd(int a, int b) {

        BigInteger b1 = BigInteger.valueOf(a);
        BigInteger b2 = BigInteger.valueOf(b);

        BigInteger gcd = b1.gcd(b2);

        return gcd.intValue();
    }
    public static int lcm(int x, int y) {

        return (x * y) / gcd(x, y);
    }
}
