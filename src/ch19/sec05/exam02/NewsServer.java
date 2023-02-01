package ch19.sec05.exam02;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewsServer extends Thread {
    private static DatagramSocket datagramSocket = null;
    private static ExecutorService executorService =
            Executors.newFixedThreadPool(10);
    public static void main(String[] args) throws Exception {
        System.out.println("----------------------------------------");
        System.out.println("서버를 종료하려면 q를 입력하고 Enter 키를 입력하세요.");
        System.out.println("----------------------------------------");

        startServer();
        Scanner sc = new Scanner(System.in);
        while (true){
            String key = sc.nextLine();
            if(key.toLowerCase().equals("q")) break;
        }
        sc.close();

        stopServer();
    }
    public static void startServer(){
        Thread thread = new Thread(){
            @Override
            public void run() {
                try{
                    datagramSocket = new DatagramSocket(50001);
                    System.out.println("[서버] 시작됨");

                    while (true){
                        DatagramPacket receivePacket = new DatagramPacket(
                                new byte[1024],1024
                        );
                        datagramSocket.receive(receivePacket);
                        executorService.execute(()->{
                            try{
                                String newsKind = new String(receivePacket.getData(),0,receivePacket.getLength(),"UTF-8");

                                SocketAddress socketAddress =
                                        receivePacket.getSocketAddress();

                                for(int i = 1; i<=10; i++){
                                    String data = newsKind+": 뉴스"+i;
                                    byte[] bytes = data.getBytes("UTF-8");
                                    DatagramPacket sendPack = new DatagramPacket(
                                            bytes,0,bytes.length, socketAddress);
                                }
                            }catch(Exception e){}
                        });
                    }
                }catch(Exception e){
                    System.out.println("[서버] "+e.getMessage());
                }
            }
        };
    }
    public static void stopServer(){
        datagramSocket.close();
        executorService.shutdownNow();
        System.out.println("[서버] 종료됨.");
    }
}
