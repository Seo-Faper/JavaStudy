package ch17.sec12.exam03;

import ch17.sec12.exam01.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectExample {
    public static void main(String[] args) {
        List<ch17.sec12.exam01.Student> totalList = new ArrayList<>();
        totalList.add(new ch17.sec12.exam01.Student("홍길동","남",92));
        totalList.add(new ch17.sec12.exam01.Student("김수영","여",87));
        totalList.add(new Student("김자바","남",95));

        Map<String,Double> map = totalList.stream()
                .collect(
                        Collectors.groupingBy(
                                s->s.getSex(),
                                Collectors.averagingDouble(s->s.getScore())
                        )
                );
        System.out.println(map);
    }
}
