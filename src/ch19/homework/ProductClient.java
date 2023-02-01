package ch19.homework;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ProductClient {
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    private Scanner sc;

    public static void main(String[] args) {
        ProductServer productServer = new ProductServer();
        try{
            System.out.println("클라이언트 start()");
            productServer.start();
        }catch (IOException e){
            e.printStackTrace();
            productServer.stop();

        }
    }
    public void start() throws IOException {
        //서버 연결하기
        socket = new Socket("localhost", 50001);
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());
        System.out.println("[클라이언트] 서버에 연결됨");

        sc = new Scanner(System.in);

        showProduct();

    }

    private void showProduct() throws IOException {
        System.out.println("[상품 목록");
        System.out.println("-----------------------------------------------");
        System.out.println("no\t\tname\t\t\t\t\t\t\tprice\t\t\t\tstock");
        System.out.println("-----------------------------------------------");

        JSONObject request = new JSONObject();
        request.put("menu",0);
        request.put("data",new JSONObject());
        dos.writeUTF(request.toString());
        dos.flush();

        JSONObject response = new JSONObject(dis.readUTF());
        if(response.getString("status").equals("success")){
            JSONArray data = response.getJSONArray("data");
            for(int i = 0; i<data.length();i++){
                JSONObject product = data.getJSONObject(i);
                System.out.println(product.getString("no")+"\t\t"+product.getString("name")+"\t\t\t\t\t\t\t"
                        +product.getString("price")
                        +"\t\t\t\t"+product.getString("stock"));
            }
        }
        showMenu();
    }

    private void showMenu() throws IOException {
        System.out.println("-----------------------------------------------");
        System.out.println("메뉴 : 1. Create | 2. Update | 3. Delete | 4.Exit");
        System.out.print("선택 >");
        int sel = Integer.parseInt(sc.nextLine());

        if(sel==1)create();
        else if(sel==2) update();
        else if(sel==3) delete();
        else if(sel==4) exit();
    }

    private void exit() {
        stop();
    }

    private void delete() throws IOException {
        System.out.println("[상품 삭제]");
        System.out.print("상품 번호: ");
        int no = Integer.parseInt(sc.nextLine());

        //상품 수정 요청하기
        JSONObject data = new JSONObject();
        data.put("no", no);

        JSONObject request = new JSONObject();
        request.put("menu", 3);
        request.put("data", data);

        dos.writeUTF(request.toString());
        dos.flush();

        //응답 받기
        JSONObject response = new JSONObject(dis.readUTF());
        if(response.getString("status").equals("success")) {
            showProduct();
        }
    }

    private void update() throws IOException {
        System.out.println("[상품 수정]");
        Product product = new Product();
        System.out.print("상품 번호: ");
        product.setNo(Integer.parseInt(sc.nextLine()));
        System.out.print("이름 변경: ");
        product.setName(sc.nextLine());
        System.out.print("가격 변경: ");
        product.setPrice(Integer.parseInt(sc.nextLine()));
        System.out.print("재고 변경: ");
        product.setStock(Integer.parseInt(sc.nextLine()));


        JSONObject data = new JSONObject();
        data.put("no", product.getNo());
        data.put("name", product.getName());
        data.put("price", product.getPrice());
        data.put("stock", product.getStock());

        JSONObject request = new JSONObject();
        request.put("menu", 2);
        request.put("data", data);

        dos.writeUTF(request.toString());
        dos.flush();

        JSONObject response = new JSONObject(dis.readUTF());

        if(response.getString("status").equals("success")) {
            showProduct();
        }
    }

    private void create() throws IOException {
        System.out.println("[상품 생성]");
        Product product = new Product();
        System.out.print("상품 이름 : ");
        product.setName(sc.nextLine());
        System.out.print("상품 가격 : ");
        product.setPrice(Integer.parseInt(sc.nextLine()));
        System.out.print("상품 재고 : ");
        product.setStock(Integer.parseInt(sc.nextLine()));
        JSONObject data = new JSONObject();
        data.put("name", product.getName());
        data.put("price", product.getPrice());
        data.put("stock", product.getStock());

        JSONObject request = new JSONObject();
        request.put("menu", 1);

        request.put("data", data);

        dos.writeUTF(request.toString());
        dos.flush();

        JSONObject response = new JSONObject(dis.readUTF());
        if(response.getString("status").equals("success")) {
            showProduct();
        }
    }


    public void stop(){
        try{
            socket.close();
            sc.close();
        }catch(Exception e){
            System.out.println("[클라이언트] 종료");
        }
    }

}
