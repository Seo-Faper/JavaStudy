package ch19.homework;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProductServer {
    private ServerSocket serverSocket;
    private ExecutorService threadPool;
    private List<Product> products;
    private int number;

    public static void main(String[] args) {
        ProductServer productServer = new ProductServer();
        try{
            productServer.start();
        }catch(IOException e){
            productServer.stop();
        }
    }
    public void start() throws IOException{
        serverSocket = new ServerSocket(50001);
        threadPool = Executors.newFixedThreadPool(100);
        products = new Vector<Product>();

        System.out.println("[서버] 시작됨");

        while (true){
            Socket socket = serverSocket.accept();
            SocketClient sc = new SocketClient(socket);
        }

    }
    public void stop(){
        try{
            serverSocket.close();
            threadPool.shutdownNow();
            System.out.println("[서버] 종료됨");
        } catch (IOException e) {

        }

    }
    public class SocketClient{
        private Socket socket;
        private DataInputStream dis;
        private DataOutputStream dos;
        public SocketClient( Socket socket){
            try{
                this.socket = socket;
                this.dis = new DataInputStream(socket.getInputStream());
                this.dos = new DataOutputStream(socket.getOutputStream());
                receive();
            }catch(IOException e){

            }
        }
        public void receive(){
            threadPool.execute(()->{
                try{
                    while (true){
                        String receiveJson = dis.readUTF();

                        JSONObject request = new JSONObject(receiveJson);
                        int sel = request.getInt("menu");
                        System.out.println(sel);
                        if(sel==0) list(request);
                        else if(sel==1) create(request);
                        else if(sel==2) update(request);
                        else if(sel==3) delete(request);
                    }
                }catch (IOException e){
                        close();
                }
            });
        }
        public void close(){
            try{
                socket.close();
            }catch (Exception e){

            }
        }

        private void update(JSONObject request) throws IOException {
            JSONObject data = request.getJSONObject("data");
            int no = data.getInt("no");
            for(int i= 0; i<products.size(); i++) {
                Product product = products.get(i);
                if(product.getNo() == no) {
                    product.setName(data.getString("name"));
                    product.setPrice(data.getInt("price"));
                    product.setStock(data.getInt("stock"));
                }
            }

            //응답 보내기
            JSONObject response = new JSONObject();
            response.put("status", "success");
            response.put("data", new JSONObject());
            dos.writeUTF(response.toString());
            dos.flush();
        }

        private void delete(JSONObject request) throws IOException {
            JSONObject data = request.getJSONObject("data");
            int no = data.getInt("no");
            for(int i = 0; i<products.size(); i++){
                if(products.get(i).getNo()== no) {
                    products.remove(i);
                    break;
                }
            }

            //응답 보내기
            JSONObject response = new JSONObject();
            response.put("status", "success");
            response.put("data", new JSONObject());
            dos.writeUTF(response.toString());
            dos.flush();
        }

        private void create(JSONObject request) throws IOException {

            JSONObject data = request.getJSONObject("data");
            Product product = new Product();
            product.setNo(++number);
            product.setName(data.getString("name"));
            product.setPrice(data.getInt("price"));
            product.setStock(data.getInt("stock"));
            products.add(product);

            JSONObject response = new JSONObject();
            response.put("status", "success");
            response.put("data", new JSONObject());
            dos.writeUTF(response.toString());
            dos.flush();
        }

        private void list(JSONObject request) throws IOException {

            JSONArray data = new JSONArray();
            for (Product p : products) {
                JSONObject product = new JSONObject();
                product.put("no", p.getNo());
                product.put("name", p.getName());
                product.put("price", p.getPrice());
                product.put("stock", p.getStock());
                data.put(product);
            }
            JSONObject response = new JSONObject();
            response.put("status", "success");
            response.put("data", data);
            dos.writeUTF(response.toString());
            dos.flush();
        }
    }
}
