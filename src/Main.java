import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int myAccount = 0;

        while (true){
            System.out.println();
           System.out.println("------------------------------------");
           System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
           System.out.println("------------------------------------");
           System.out.print("선택> ");
           String userSelect = sc.nextLine();
           if(userSelect.equals("1")){
               System.out.print("예금액>");
               myAccount += (Integer.parseInt(sc.nextLine()));
           }else if(userSelect.equals("2")){
               System.out.print("출금액>");
               myAccount -= (Integer.parseInt(sc.nextLine()));

           }else if(userSelect.equals("3")){
               System.out.print("잔고>");
               System.out.println(myAccount);

           }else if(userSelect.equals("4")){
               System.out.println("프로그램 종료");
               break;
           }
        }
    }
}