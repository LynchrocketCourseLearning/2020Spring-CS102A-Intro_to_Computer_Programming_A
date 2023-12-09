import java.util.Scanner;

public class User {

    private String account;
    private String password;
    private double money;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }


    public void introduce() {
        System.out.printf("%s's account has a balance of %.2f dollar\n", account, money);
    }

    public void expense(double value, Scanner in) {
        if (value > money) {
            System.out.printf("Plan to expense %.2f dollar but no sufficient funds\n", value);
        } else {
            System.out.printf("Plan to expense %.2f dollar\n", value);
            System.out.println("Please input your password:");
            String a = in.next();
            if (a.equals(password)) {
                money = money - value;
                System.out.printf("Expense %.2f dollar and balance %.2f dollar\n", value, money);
            }
        }
    }

    public void income(double value) {
        money = money + value;
        System.out.printf("Got %.2f as income, balance is %.2f dollar\n", value, money);
    }
}