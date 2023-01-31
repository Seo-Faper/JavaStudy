package ch18.sec03.exam03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyExample {
    public static void main(String[] args) throws Exception{
        String originalFileName = "C:/Temp/test.jpg";
        String targetFileName = "C:/Temp/test2.jpg";

        InputStream is = new FileInputStream(originalFileName);
        OutputStream os = new FileOutputStream(targetFileName);

        byte[] data = new byte[1024];
        while (true){
            int num = is.read(data);
            if (num == -1) break;

            os.write(data,0,num);

        }
        os.flush(); // 내부 버퍼 잔류 바이트를 출력하고 버퍼를 비움
        os.close();
        is.close();
        System.out.println("복사가 완료되었습니다.");
    }
}
