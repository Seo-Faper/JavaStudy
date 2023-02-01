package ch19;

import java.io.*;


public class BOJ_2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String k = bf.readLine();
        int a = Integer.parseInt(k.split(" ")[0]);
        int b = Integer.parseInt(k.split(" ")[1]);
        int v = Integer.parseInt(k.split(" ")[2]);

        int ans = ((v-a)%(a-b)!=0) ? (v-a)/(a-b)+2 : (v-a)/(a-b)+1;

        bw.write(ans+"\n");
        bw.flush();
        bw.close();
    }
}
