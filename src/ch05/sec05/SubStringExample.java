package ch05.sec05;

public class SubStringExample
{
    public static void main(String[] args) {
        String ssn = "880815-123456";
        String firstNum = ssn.substring(0,6); // 0~6까지 이므로 "880815"
        String secondNum = ssn.substring(7); // 7 ~ 끝까지 이므로 "1234567"

        System.out.println(firstNum);
        System.out.println(secondNum);
    }
}
