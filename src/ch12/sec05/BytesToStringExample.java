package ch12.sec05;

import java.util.Arrays;

public class BytesToStringExample {
    public static void main(String[] args) throws Exception{
        String data = "자바";

        byte[] arr1 = data.getBytes(); // 아무것도 적지 않을 시 UTF-8
        System.out.println(Arrays.toString(arr1));

        String str1 = new String(arr1);
        System.out.println(str1);

        byte[] arr2 = data.getBytes("EUC-KR");
        System.out.println(Arrays.toString(arr2));

        String str2 = new String(arr2);
        System.out.println(str2);
    }
}
