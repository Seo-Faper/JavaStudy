package ch10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11945 {
    public static void main(String[] args) {
        try{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String[] strs = bf.readLine().split(" ");
            int n = Integer.parseInt(strs[0]);
            int m = Integer.parseInt(strs[1]);
            char[][] board = new char[n][m];
            for(int i = 0; i<n; i++){
                String k = bf.readLine();
                for(int j = 0; j<m; j++){
                    board[i][j] = k.charAt(j);
                }
            }
            for(int i = 0; i<n; i++){
                for(int j = m-1; j>=0; j--){
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
        } catch (Exception e){

        }


    }
}
