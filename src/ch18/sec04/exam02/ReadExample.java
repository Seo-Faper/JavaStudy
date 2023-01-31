package ch18.sec04.exam02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadExample {
    public static void main(String[] args) {
        try{

            // 방법 1
            Reader reader = null;
            reader = new FileReader("C:/Temp/test.txt");
            while (true){
                int data = reader.read();
                if(data == -1) break;
                System.out.print((char)data);
            }
            System.out.println();


            //방법 2
            reader = new FileReader("C:/Temp/test.txt");
            char[] data = new char[100];
            while (true){
                int num = reader.read(data);
                if(num == -1) break;
                for(int i = 0; i<num; i++){
                    System.out.print(data[i]);
                }
            }
            reader.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
