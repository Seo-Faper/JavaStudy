package ch10;

import java.util.Scanner;
import java.util.Set;

public class BOJ_1264 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Character> c = Set.of('a','e','i','o','u');
        while (true){
            String k = sc.nextLine().toLowerCase();
            int tmp = 0;
            if(k.equals("#"))break;
            for(int i = 0; i<k.length(); i++){
                if(c.contains(k.charAt(i))) tmp++;
            }
            System.out.println(tmp);
        }
    }
}
