public class Account {
    private int number;
    private String holder;
    private Double balance;

    public Account(int number, String holder) {
        this.number = number;
        this.holder = holder;
        this.setBalance(0.00);
    }

    public Account(int number, String holder, Double balance) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
    }

    public int getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    private void setBalance(Double balance) {
        this.balance = balance;
    }

    public void deposit(Double money){
        this.setBalance( getBalance() + money);
    }

    public void withdraw(Double money){
        this.setBalance(getBalance() - money - 5.00);
    }

    @Override
    public String toString() {
        return "----- Account -----" + '\n' +
                "number = " + number + '\n' +
                "holder = " + holder + '\n' +
                "balance = " + balance +
                '\n';
    }
}
