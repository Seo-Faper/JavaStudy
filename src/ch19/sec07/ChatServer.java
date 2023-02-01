package ch19.sec07;

import org.json.JSONObject;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {
    ServerSocket serverSocket;
    ExecutorService threadPool = Executors.newFixedThreadPool(100);
    Map<String, SocketClient> chatRoom
            = Collections.synchronizedMap(new HashMap<>());
    public void start() throws IOException{
        serverSocket = new ServerSocket(50001);
        System.out.println("[서버] 시작됨");

        Thread thread = new Thread(()->{
            try{
                while (true){
                    Socket socket = serverSocket.accept();
                    SocketClient sc = new SocketClient(this, socket);
                }
            }catch(Exception e){

            }

        });
        thread.start();
    }

    public void addSocketClient(SocketClient socketClient){
        String key = socketClient.chatName+"@"+socketClient.clientIp;
        chatRoom.put(key,socketClient);
        System.out.println("입장: "+key);
        System.out.println("현재 채팅자 수 : "+chatRoom.size()+"\n");
    }
    public void removeSocketClient(SocketClient socketClient){
        String key = socketClient.chatName+"@"+socketClient.clientIp;
        chatRoom.remove(key);
        System.out.println("나감: "+key);
        System.out.println("현재 채팅자 수 : "+chatRoom.size()+"\n");
    }
    public void sendToAll(SocketClient sender, String message){
        JSONObject root = new JSONObject();
        root.put("clientIP",sender.clientIp);
        root.put("clientName",sender.chatName);
        root.put("message",message);
        String json = root.toString();

        Collection<SocketClient> socketClients = chatRoom.values();
        for(SocketClient sc : socketClients){
            if(sc == sender) continue;
            sc.send(json);
        }
    }
    public void stop(){
        try{
            serverSocket.close();
            threadPool.shutdownNow();
            chatRoom.values().stream().forEach(e-> e.close());
            System.out.println("[서버] 종료됨");
        }catch (IOException e){}
    }

    public static void main(String[] args) {
        try{
            ChatServer chatServer = new ChatServer();
            chatServer.start();

            System.out.println("----------------------------------------");
            System.out.println("서버를 종료하려면 q를 입력하고 Enter 키를 입력하세요.");
            System.out.println("----------------------------------------");

            Scanner sc = new Scanner(System.in);
            while (true){
                String key = sc.nextLine();
                if(key.toLowerCase().equals("q")) break;
            }
            sc.close();
            chatServer.stop();
        }catch(IOException e){
            System.out.println("[서버] "+e.getMessage());
        }

    }
}
