package ch17.sec06.exam01;

import java.util.ArrayList;
import java.util.List;

public class MapExample {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("홍길동",85));
        students.add(new Student("홍길동",92));
        students.add(new Student("홍길동",87));

        students.stream()
                .mapToInt(s -> s.getScore())
                .forEach(e -> System.out.println(e));
    }
}
