package ch20.mysql.sec09.exam01;

import java.sql.*;

public class UserSelectExample {
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
                    "SELECT userid, username, userpassword, userage, useremail "+
                    "FROM users "+
                    "WHERE userid=?";

            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1,"winter");

            ResultSet rs = psmt.executeQuery();
            if(rs.next()){
                User user = new User();
                user.setUserId(rs.getString("userid"));
                user.setUserName(rs.getString("username"));
                user.setUserPassword(rs.getString("userpassword"));
                user.setUserAge(rs.getInt(4));
                user.setUserEmail(rs.getString(5));
                System.out.println(user);
            }else{
                System.out.println("사용자 아이디가 존재하지 않음");
            }
        } catch (ClassNotFoundException e) {
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
