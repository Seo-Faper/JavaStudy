package BOJ_problem;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10819 {
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i =  0; i<n; i++) arr[i] = sc.nextInt();
        per1(arr,0,n);
        System.out.println(answer);
    }
    //1. Swap 함수를 이용해 구현 - 순서 없이 n 개중에서 r 개를 뽑는 경우
    static void per1(int[] arr, int depth, int n) {
        if(depth == n) {
            int ans = 0;
            for(int i = 0; i<n-1; i++){
                ans += Math.abs(arr[i]-arr[i+1]);
            }
            answer = Math.max(ans,answer);
            return;
        }

        for(int i=depth; i<n; i++) {
            swap(arr, depth, i);
            per1(arr, depth + 1, n);
            swap(arr, depth, i);
        }
    }

    static void swap(int[] arr, int depth, int i) { //두 배열의 값을 바꾸는 Swap 함수
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

}
