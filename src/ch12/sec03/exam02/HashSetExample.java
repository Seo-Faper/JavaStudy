package ch12.sec03.exam02;

import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        Student s1 = new Student(1,"홍길동");
        hashSet.add(s1);

        Student s2 = new Student(1,"홍길동");
        hashSet.add(s2);

        System.out.println(hashSet.toString());

    }
}
