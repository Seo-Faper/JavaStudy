import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        int n = 0;
        int[] scores = null;
        while (true){

            System.out.println();
           System.out.println("-------------------------------------------------------");
           System.out.println("1. 학생 수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 |  5. 종료");
           System.out.println("-------------------------------------------------------");
           System.out.print("선택> ");
           String userSelect = sc.nextLine();
           if(userSelect.equals("1")){
               System.out.print("학생수>");
                n = sc.nextInt();
                scores = new int[n];
           }else if(userSelect.equals("2")){

                for(int i = 0; i<n; i++){
                    System.out.print("scores["+i+"]> ");
                    scores[i] = sc.nextInt();
                }

           }else if(userSelect.equals("3")){
               for(int i = 0; i<n; i++){
                   System.out.println("scores["+i+"] : "+scores[i]);
               }
           }else if(userSelect.equals("4")){
               System.out.println("분석");
                int sum = 0;
                int max = 0;
                for(int i = 0; i<n; i++){
                    sum +=scores[i];
                    max = Math.max(scores[i],max);
                }
                System.out.println("최고 점수: "+max);
                System.out.println("평균 점수: "+(double)sum/n);
           }else if(userSelect.equals("5")){
               System.out.println("프로그램 종료");
               break;
           }
        }
    }
}