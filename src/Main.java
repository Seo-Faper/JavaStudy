import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] num = bf.readLine().split(" ");
        int a = Integer.parseInt(num[0]);
        int b = Integer.parseInt(num[1]);
        int c = Integer.parseInt(num[2]);

        if(c-b<=0) System.out.println( -1);
        else System.out.println(a / (c-b)+1);
    }
}
