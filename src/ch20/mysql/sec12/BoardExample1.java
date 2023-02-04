package ch20.mysql.sec12;

import java.util.Scanner;

public class BoardExample1 {
    private Scanner sc = new Scanner(System.in);
    public void list(){
        System.out.println("[게시물 목록]");
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-6s%-12s%-16s%-40s\n", "no","writer","date","title");
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-6s%-12s%-16s%-40s \n",
                "1","winter","2022.01.27","게시판에 오신 것을 환영합니다.");
        System.out.printf("%-6s%-12s%-16s%-40s \n",
                "2","winter","2022.01.27","올 겨울은 몹시 춥다네.");
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
        BoardExample1 boardExample1 = new BoardExample1();
        boardExample1.list();
    }
}
