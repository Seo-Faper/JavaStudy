package ch17.sec10;

import java.util.Arrays;

public class AggregateExample {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};

        long count = Arrays.stream(arr).filter(e -> e%2==0).count();
        long sum = Arrays.stream(arr).filter(e->e%2==0).sum();
        double avg = Arrays.stream(arr).filter(e->e%2==0).average().getAsDouble();
        int max = Arrays.stream(arr).filter(e -> e%2==0).max().getAsInt();
        int min = Arrays.stream(arr).filter(e -> e%2==0).min().getAsInt();
    }
}
