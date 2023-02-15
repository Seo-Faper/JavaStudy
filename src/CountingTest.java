public class CountingTest {
    public static void main(String[] args) {
        Count count = new Count();
        for (int i = 0; i < 100; i++) {
            new Thread(){
                public void run(){
                    for (int j = 0; j < 100; j++) {
                        System.out.println(count.view());
                    }
                }
            }.start();
        }
    }
}
class Count {

    private int count;
    public int view() {return count++;}
    public int getCount() {return count;}
}