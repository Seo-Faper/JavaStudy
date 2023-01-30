package ch17.sec08;

import java.util.Arrays;

public class LoopingExample {
    public static void main(String[] args) {
        int[] intArr = {1,2,3,4,5};
        Arrays.stream(intArr)
                .filter(e->e%2==0)
                .peek(n->System.out.println(n)); // 최종 처리가 없으므로 작동하지 않음
        int total = Arrays.stream(intArr)
                .filter(e->e%2==0)
                .peek(n->System.out.println(n))
                .sum();
        System.out.println(total);

        Arrays.stream(intArr)
                .filter(e->e%2==0)
                .forEach(n->System.out.println(n));
    }
}
