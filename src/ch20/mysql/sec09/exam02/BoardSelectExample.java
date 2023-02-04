package ch20.mysql.sec09.exam02;

import ch20.mysql.sec09.exam01.User;

import java.io.*;
import java.sql.*;

public class BoardSelectExample {
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

            String sql = ""+
                    "SELECT bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata "+
                    "FROM boards "+
                    "WHERE bwriter=?";

            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1,"winter");

            ResultSet rs = psmt.executeQuery();
            while (rs.next()){
                Board board = new Board();
                board.setBno(rs.getInt("bno"));
                board.setTitle(rs.getString("btitle"));
                board.setBcontent(rs.getString("bcontent"));
                board.setBwriter(rs.getString("bwriter"));
                board.setBdate(rs.getDate("bdate"));
                board.setBfilename(rs.getString("bfilename"));
                board.setBfiledata(rs.getBlob("bfiledata"));

                System.out.println(board);

                Blob blob = board.getBfiledata();
                if(blob != null){
                    InputStream is = blob.getBinaryStream();
                    OutputStream os = new FileOutputStream("C:/Temp/"+
                            board.getBfilename());
                    is.transferTo(os);
                    os.flush();
                    os.close();
                    is.close();
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
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
