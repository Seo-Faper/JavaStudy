package ch17.sec04.sec03;

import java.util.stream.IntStream;

public class StreamExample {
    public static int sum;

    public static void main(String[] args) {
        IntStream stream = IntStream.rangeClosed(1,100);
        stream.forEach(e->sum +=e);
        System.out.println(sum);
    }
}
