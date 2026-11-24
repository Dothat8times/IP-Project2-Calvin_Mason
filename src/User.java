public class User {
    private String name;
    private int balance;
    private boolean riding;
    public User(String name, int balance) {
        this.name = name;
        this.balance = balance;
        riding = false;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public boolean isRiding() {
        return riding;
    }
}
