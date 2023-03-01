package BOJ_problem;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11055 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
            dp[i] = arr[i];
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<i; j++){
                if(arr[j] < arr[i] && dp[i] < dp[j] + arr[i]){
                    dp[i] = dp[j] + arr[i];
                }
            }
        }
      System.out.println(Arrays.stream(dp).max().getAsInt());

    }
}
