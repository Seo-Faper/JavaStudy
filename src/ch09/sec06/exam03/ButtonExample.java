package ch09.sec06.exam03;

public class ButtonExample {
    public static void main(String[] args) {
        Button btnOk = new Button();

        //Ok 버튼 클릭 이벤트를 처리할 ClickListener 구현 클래스 (로컬 클래스)
        class OkListener implements Button.ClickListener{

            @Override
            public void onClick() {
                System.out.println("Ok 버튼을 클릭했습니다.");
            }
        }
        //Ok 버튼 객체에 ClickListener 구현 객체 주입
        btnOk.setClickListener(new OkListener());

        btnOk.click();
        //---------------------------

        Button btnCancel = new Button();
        class CancelListener implements Button.ClickListener{

            @Override
            public void onClick() {
                System.out.println("Cancel 버튼을 클릭했습니다.");
            }
        }
        btnCancel.setClickListener(new CancelListener());
        btnCancel.click();
    }
}
