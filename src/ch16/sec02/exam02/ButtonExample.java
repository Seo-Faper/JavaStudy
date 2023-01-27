package ch16.sec02.exam02;

public class ButtonExample {
    public static void main(String[] args) {
        Button button = new Button();
        
        button.setClickListener(()->{
            System.out.println("OK 버튼 클릭");
        });

        button.click();

        Button btnCancel = new Button();
        btnCancel.setClickListener(()->{
            System.out.println("Cancel 버튼 클릭");
        });
        btnCancel.click();
    }
}
