package ch03.sec07;

public class LogicalOperatorExample
{
    public static void main(String[] args) {
        int charCode = 'A';
        if( (65 <=charCode) & (charCode<=90)){
            System.out.println("대문자군요.");
        }
        if( (97 <=charCode ) && (charCode <=122)){
            System.out.println("소문자군요.");
        }
        if((48<=charCode) && (charCode<=57)){
            System.out.println("0~9 숫자군요.");
        }
    }
}
