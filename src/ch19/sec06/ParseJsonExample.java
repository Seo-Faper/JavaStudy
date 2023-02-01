package ch19.sec06;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

public class ParseJsonExample {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new FileReader("C:/Temp/member.json", Charset.forName("UTF-8"))
        );
        String json = br.readLine();
        br.close();

        JSONObject root = new JSONObject(json);

        System.out.println("id: "+root.getString("id"));
        System.out.println("name: "+root.getString("name"));
        System.out.println("age: "+root.getInt("age"));
        System.out.println("student: "+root.getBoolean("student"));

        JSONObject tel = root.getJSONObject("tel");
        System.out.println("home: "+tel.getString("home"));
        System.out.println("mobile: "+tel.getString("mobile"));

        JSONArray skill = root.getJSONArray("skill");

    }
}
