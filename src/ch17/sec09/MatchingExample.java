package ch17.sec09;

import java.util.Arrays;

public class MatchingExample {
    public static void main(String[] args) {
        int[] intArr = {2,4,6};

        boolean result = Arrays.stream(intArr).allMatch(a ->a%2==0);// 짝수인 것만 존재하면 true

        System.out.println(result);

        result = Arrays.stream(intArr).anyMatch(a -> a%3 ==0); // 하나라도 3의 배수가 존재하면 true
        System.out.println(result);

        result = Arrays.stream(intArr).noneMatch(a -> a%3==0); // 3의 배수가 하나도 존재하지 않으면 true
        System.out.println(result);
    }
}
