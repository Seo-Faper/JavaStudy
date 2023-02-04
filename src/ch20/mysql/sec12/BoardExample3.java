package ch20.mysql.sec12;

import java.sql.*;
import java.util.Scanner;

public class BoardExample3 {
    private Scanner sc = new Scanner(System.in);
    private Connection conn;
    private String name = "";
    private boolean session = false;

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
        if(session)  System.out.println("[게시물 목록] 사용자 :"+name);
        else System.out.println("[게시물 목록]");
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
        if(session) System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Join | 5.LogOut | 6.Exit ");
        else System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Join | 5.Login | 6.Exit ");
        System.out.print("메뉴 선택: ");
        System.out.println("");
        String sel = sc.nextLine();
        switch (sel){
            case "1" -> create();
            case "2" -> read();
            case "3" -> clear();
            case "4" -> join();
            case "5" -> {

                if(!session)login();
                else{
                    session = false;
                    name = "";
                    list();
                }

            }
            case "6" -> exit();
        }
    }

    private void join() {
        User user = new User();
        System.out.println("[새로운 사용자 등록]");
        System.out.print("아이디: ");
        user.setUserId(sc.nextLine());
        System.out.print("이름: ");
        user.setUserName(sc.nextLine());
        System.out.print("비밀번호: ");
        user.setUserPassword(sc.nextLine());
        System.out.println("나이: ");
        user.setUserAge(Integer.parseInt(sc.nextLine()));
        System.out.println("이메일: ");
        user.setUserEmail(sc.nextLine());
        System.out.println("------------------------------------------------------");
        System.out.println("보조 메뉴 : 1. OK | 2. Cancel");
        System.out.print("메뉴 선택 : ");
        String menuNo = sc.nextLine();
        if(menuNo.equals("1")){
            try{
                String sql = "" +
                        "INSERT INTO users (userid, username, userpassword, userage, useremail) " +
                        "VALUES (?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,user.getUserId());
                pstmt.setString(2, user.getUserName());
                pstmt.setString(3, user.getUserPassword());
                pstmt.setInt(4, user.getUserAge());
                pstmt.setString(5, user.getUserEmail());
                pstmt.executeUpdate();
                pstmt.close();
            }catch(Exception e){

            }
        }
        list();
    }

    private void login() {
        String id = "";
        String pwd = "";
        System.out.println("[로그인]");
        System.out.print("아이디: ");
        id = sc.nextLine();
        System.out.print("비밀번호: ");
        pwd = sc.nextLine();
        System.out.println("------------------------------------------------------");
        System.out.println("보조 메뉴 : 1. OK | 2. Cancel");
        System.out.print("메뉴 선택 : ");
        String menuNo = sc.nextLine();
        if(menuNo.equals("1")){
            try{
                String sql = ""+
                        "SELECT userid, username, userpassword, userage, useremail "+
                        "FROM users "+
                        "WHERE userid=?";

                PreparedStatement psmt = conn.prepareStatement(sql);
                psmt.setString(1,id);

                ResultSet rs = psmt.executeQuery();
                if(rs.next()){
                    if(id.equals(rs.getString("userid")) && pwd.equals(rs.getString("userpassword"))){
                        session = true;
                        name = rs.getString("username");
                        list();
                    }
                }else{
                    System.out.println("아이디가 존재하지 않습니다.");
                    join();
                }
            }catch(Exception e){

            }
        }
        list();

    }

    private void clear() {
        System.out.println("[게시물 전체 삭제]");
        System.out.println("-------------------------------------------------------");
        System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
        System.out.print("메뉴 선택: ");
        String menuNo = sc.nextLine();
        if(menuNo.equals("1")) {
             try {
                 String sql = "TRUNCATE TABLE boards";
                 PreparedStatement pstmt = conn.prepareStatement(sql);
                 pstmt.executeUpdate();
                 pstmt.close();
                 } catch (Exception e) {
                 e.printStackTrace();
                 exit();
                 }
             }
        list();
    }

    private void exit() {
        if(conn != null){
            try{
                conn.close();
            }catch(SQLException e){

            }
        }
        System.out.println("** 게시판 종료 **");
        System.exit(0);
    }

    private void read() {
        System.out.println("[게시물 읽기]");
        System.out.print("bno: ");
        int bno = Integer.parseInt(sc.nextLine());
        try{
            String sql = "" +
                     "SELECT bno, btitle, bcontent, bwriter, bdate " +
                     "FROM boards " +
                     "WHERE bno= ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bno);
             ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                 Board board = new Board();
                 board.setBno(rs.getInt("bno"));
                 board.setBtitle(rs.getString("btitle"));
                 board.setBcontent(rs.getString("bcontent"));
                 board.setBwriter(rs.getString("bwriter"));
                 board.setBdate(rs.getDate("bdate"));
                 System.out.println("#############");
                 System.out.println("번호: " + board.getBno());
                 System.out.println("제목: " + board.getBtitle());
                 System.out.println("내용: " + board.getBcontent());
                 System.out.println("작성자: " + board.getBwriter());
                 System.out.println("날짜: " + board.getBdate());
                 System.out.println("#############");
                 System.out.println("----------------------");
                 System.out.println("보조 메뉴 : 1.Update | 2.Delete | 3.List");
                 System.out.print("메뉴 선택");
                 String menuNo = sc.nextLine();
                if (menuNo.equals("1")) {
                    update(board);
                }else if(menuNo.equals("2")){
                    delete(board);
                }else{

                }
            }
             rs.close();
             pstmt.close();
            }    catch(Exception e){}
        list();
    }
    private void delete(Board board){
        try{
            String sql = "DELETE FROM boards WHERE bno=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,board.getBno());
            pstmt.executeUpdate();
            pstmt.close();
        }catch(Exception e){
            exit();
        }
        list();
    }
    private void update(Board board) {

        System.out.println("[수정 내용 입력]");
         System.out.print("제목: ");
         board.setBtitle(sc.nextLine());
         System.out.print("내용: ");
         board.setBcontent(sc.nextLine());
         System.out.print("작성자: ");
         board.setBwriter(sc.nextLine());

         //보조 메뉴 출력
         System.out.println("------------------------------------------------------");
         System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
         System.out.print("메뉴 선택: ");
         String menuNo = sc.nextLine();
         if(menuNo.equals("1")) {

            try {
                String sql = "" +
                         "UPDATE boards SET btitle= ?, bcontent= ?, bwriter= ? " +
                         "WHERE bno= ?";
                 PreparedStatement pstmt = conn.prepareStatement(sql);
                 pstmt.setString(1, board.getBtitle());
                 pstmt.setString(2, board.getBcontent());
                 pstmt.setString(3, board.getBwriter());
                 pstmt.setInt(4, board.getBno());
                 pstmt.executeUpdate();
                 pstmt.close();
            } catch (Exception e) {
                 e.printStackTrace();
                 exit();
                 }
             }
         list();
    }
    private void create() {
        Board board = new Board();
        System.out.println("[새 게시물 입력]");
        System.out.print("제목: ");
        board.setBtitle(sc.nextLine());
        System.out.print("내용: ");
        board.setBcontent(sc.nextLine());
        System.out.print("작성자: ");
        board.setBwriter(sc.nextLine());

        System.out.println("------------------------------------------------------");
        System.out.println("보조 메뉴 : 1. OK | 2. Cancel");
        System.out.print("메뉴 선택 : ");
        String menuNo = sc.nextLine();
        if(menuNo.equals("1")){
            try{
                String sql = ""+
                        "INSERT INTO boards (btitle, bcontent, bwriter, bdate) " +
                        "VALUES (?, ?, ?, now())";
                PreparedStatement psmt = conn.prepareStatement(sql);
                psmt.setString(1,board.getBtitle());
                psmt.setString(2,board.getBcontent());
                psmt.setString(3,board.getBwriter());
                psmt.executeUpdate();
                psmt.close();
            }catch(Exception e){

            }
        }
        list();
    }

    public static void main(String[] args) {
        BoardExample3 boardExample3 = new BoardExample3();
        boardExample3.list();
    }
}
