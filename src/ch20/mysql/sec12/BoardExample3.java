package ch20.mysql.sec12;

import java.sql.*;
import java.util.Scanner;

public class BoardExample3 {
    private Scanner sc = new Scanner(System.in);
    private Connection conn;

    public BoardExample3(){
        try {
//JDBC Driver 등록
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/thisisjava",
                    "root",
                    "mysql"
            );

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void list(){
        System.out.println("[NEW 게시물 목록]");
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-6s%-12s%-16s%-40s\n", "no","writer","date","title");
        System.out.println("-------------------------------------------------------");
        try{
            String sql = ""+
                    "SELECT bno, btitle, bcontent, bwriter, bdate "+
                    "FROM boards "+
                    "ORDER BY bno DESC";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Board board = new Board();
                board.setBno(rs.getInt("bno"));
                board.setBtitle(rs.getString("btitle"));
                board.setBcontent(rs.getString("bcontent"));
                board.setBwriter(rs.getString("bwriter"));
                board.setBdate(rs.getDate("bdate"));
                System.out.printf("%-6s%-12s%-16s%-40s \n",
                        board.getBno(),
                        board.getBwriter(),
                        board.getBdate(),
                        board.getBtitle());
            }
            rs.close();
            pstmt.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        mainMenu();
    }
    public void mainMenu(){
        System.out.println("------------------------------------------------------");
        System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit");
        System.out.print("메뉴 선택: ");
        System.out.println("");
        String sel = sc.nextLine();
        switch (sel){
            case "1" -> create();
            case "2" -> read();
            case "3" -> clear();
            case "4" -> exit();
        }
    }

    private void exit() {
        System.out.println("***exit() 실행됨***");
        list();
    }

    private void clear() {
        System.out.println("***clear() 실행됨***");
        list();
    }

    private void read() {
        System.out.println("***read() 실행됨***");
        list();
    }

    private void create() {
        System.out.println("***create() 실행됨***");
        list();
    }

    public static void main(String[] args) {
        BoardExample3 boardExample3 = new BoardExample3();
        boardExample3.list();
    }
}
