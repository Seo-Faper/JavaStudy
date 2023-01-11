package ch05.sec03;

public class ReferenceVariableCompareExample
{
    public static void main(String[] args) {
        int[] arr1;
        int[] arr2;
        int[] arr3;

        arr1 = new int[] {1,2,3}; // {1,2,3}을 arr1에 대입
        arr2 = new int[] {1,2,3}; // {1,2,3}을 arr2에 대입
        arr3 = arr2; // arr3에 arr2의 주소값을 대입

        System.out.println(arr1 == arr2);
        System.out.println(arr2 == arr3);

    }

}
