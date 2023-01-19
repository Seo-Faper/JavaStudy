package ch11.sec02.exam01;

public class ExceptionHandlingExample {
    public static void printLength(String data){
        int result = data.length();
        System.out.println("문자 수 : "+result);
    }
    public static void main(String[] args) {
        printLength("ThisIsJava");
        printLength(null);
    }
}
