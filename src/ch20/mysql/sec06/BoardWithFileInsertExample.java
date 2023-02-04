package ch20.mysql.sec06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;

public class BoardWithFileInsertExample {
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

            String sql = "" +
                    "INSERT INTO boards (btitle, bcontent, bwriter, bdate, bfilename, bfiledata) " +
             "VALUES (?, ?, ?, now(), ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1,"눈 오는 날");
            pstmt.setString(2,"함박눈이 내려요.");
            pstmt.setString(3,"winter");
            pstmt.setString(4,"snowman.jpg");
            pstmt.setBlob(5, new FileInputStream("src/ch20/mysql/sec06/snowman.jpg"));
            int rows = pstmt.executeUpdate();
            System.out.println("수정된 행 수 : "+rows);


             if(rows == 1) {
                ResultSet rs = pstmt.getGeneratedKeys();
                if(rs.next()) {
                     int bno = rs.getInt(1);
                     System.out.println("저장된 bno: " + bno);
                     }
                 rs.close();
             }
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
