package ch17.sec12.exam02;

import ch17.sec12.exam01.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectExample {
    public static void main(String[] args) {
        List<Student> totalList = new ArrayList<>();
        totalList.add(new Student("홍길동","남",92));
        totalList.add(new Student("김수영","여",87));
        totalList.add(new Student("김자바","남",95));

        Map<String, List<Student>> map = totalList.stream().collect(
                Collectors.groupingBy(s -> s.getSex())
        );

        List<Student> maleList = map.get("남");
        maleList.stream().forEach(s->System.out.println(s.getName()));
        System.out.println();

        List<Student> famaleList = map.get("여");
        famaleList.forEach(s->System.out.println(s.getName()));


    }
}
