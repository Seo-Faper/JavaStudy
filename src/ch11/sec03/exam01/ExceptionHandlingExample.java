package ch11.sec03.exam01;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        String[] array = {"100","1oo"};

        for(int i = 0; i<array.length; i++){
            try{
                int value = Integer.parseInt(array[i]);
            }catch (ArrayIndexOutOfBoundsException e){
                e.printStackTrace();
                System.out.println("배열 길이 초과됨");
            }catch (NumberFormatException e){
                e.printStackTrace();
                System.out.println("숫자로 변환할 수 없음");
            }
        }
    }
}
