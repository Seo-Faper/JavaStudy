package ch06.homework;

public class Account
{
    final static int MIN_BALANCE = 0;
    final static int MAX_BALANCE = 100000;

    private int balance;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        if(balance < MIN_BALANCE && balance > MAX_BALANCE) return;
        this.balance = balance;
    }
}
