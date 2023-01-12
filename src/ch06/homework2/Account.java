package ch06.homework2;

public class Account {
    private String payNum;
    private String owner;
    private int balance;


    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Account(String payNum, String owner , int balance) {
        this.payNum = payNum;
        this.balance = balance;
        this.owner = owner;
    }

    public String getPayNum() {
        return payNum;
    }

    public void setPayNum(String payNum) {
        this.payNum = payNum;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        if(balance < 0) return;
        this.balance = balance;
    }
}
