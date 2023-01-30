package ch17.sec05;

import java.util.ArrayList;
import java.util.List;

public class FilteringExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("홍길동");    list.add("신용권");
        list.add("신도라애몽"); list.add("신민철");
        list.add("김기동");    list.add("김기동");

        list.stream().distinct().forEach(e->System.out.println(e)); // 중복 제거

        list.stream().filter(e-> e.startsWith("신")).forEach(e->System.out.println(e)); // 성씨가 신인 것만

        list.stream().distinct().filter(e->e.startsWith("신")).forEach(e->System.out.println(e)); // 파이프라인
    }
}
