package ch20.mysql.sec07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BoardUpdateExample {
    public static void main(String[] args) {
        Connection conn = null;

        try {
            //JDBC Driver 등록
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/thisisjava",
                    "root",
                    "mysql"
            );

            String sql = new StringBuilder()
                    .append("UPDATE boards SET ")
                    .append("btitle=?, ")
                    .append("bcontent=?, ")
                    .append("bfilename=?, ")
                    .append("bfiledata=? ")
                    .append("WHERE bno=?")
                    .toString();

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"눈사람");
            pstmt.setString(2,"눈으로 만든 사람");
            pstmt.setString(3,"snowman.jpg");
            pstmt.setBlob(4, new FileInputStream("src/ch20/mysql/sec07/snowman.jpg"));
            pstmt.setInt(5,2);
            int rows = pstmt.executeUpdate();
            System.out.println("수정된 행 수 : "+rows);
        } catch (ClassNotFoundException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(conn != null) {
                try {
                    //연결 끊기
                    conn.close();
                    System.out.println("연결 끊기");
                } catch (SQLException e) {}
            }
        }
    }

}
