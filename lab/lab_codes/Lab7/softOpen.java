import java.util.ArrayList;
import java.util.Scanner;


public class softOpen {
    public static ArrayList generateMenu() {
        ArrayList<Food> type = new ArrayList<Food>();
        type.add(new Food());
        type.get(0).setType("Seafood");
        type.get(0).setId(1);
        type.get(0).setName("pizza");
        type.get(0).setSize(11);
        type.get(0).setPrice(12.00);
        type.add(new Food());
        type.get(1).setType("Beef");
        type.get(1).setId(2);
        type.get(1).setName("pizza");
        type.get(1).setSize(9);
        type.get(1).setPrice(10.00);
        type.add(new Food());
        type.get(2).setType("Seafood");
        type.get(2).setId(3);
        type.get(2).setName("fried rice");
        type.get(2).setSize(5);
        type.get(2).setPrice(12.00);
        type.add(new Food());
        type.get(3).setType("Beef");
        type.get(3).setId(4);
        type.get(3).setName("noodles");
        type.get(3).setSize(6);
        type.get(3).setPrice(14.00);
        return type;
    }

    public static void getMenu(ArrayList<Food> foodList) {
        System.out.println("--------------welcome,this is Start of the Menu--------------");
        for (int i = 0; i < 4; i++) {
            foodList.get(i).showInformation();
        }
        System.out.println("--------------welcome,this is  End  of the Menu--------------");
    }

    public static User generateUser(Scanner in) {
        User get = new User();
        System.out.print("Please input name:");
        get.setAccount(in.next());
        System.out.print("balance($):");
        get.setMoney(in.nextInt());
        get.setPassword("123456");
        return get;
    }

    public static void userConsume(ArrayList<Food> print, User user, Scanner in) {
        getMenu(print);
        System.out.println("input food ID and the number you want,to exit input 0 as foodID");
        int id = 1;
        double expense = 0;
        while (id != 0) {
            System.out.print("food id(input 0 to end the select):");
            id = in.nextInt();
            if (id == 0) {
                System.out.println("select end");
                break;
            }
            System.out.print("number of this food:");
            int number = in.nextInt();
            expense += number * print.get(id - 1).getPrice();
            if (id == 0) {
                System.out.println("select end");
                System.out.printf("Plan to expense %.2f\n", expense);
                break;
            }
        }
        System.out.println("Please input your password:");
        String psd = in.next();
        if (psd.equals("123456")) {
            System.out.printf("Expense %.2f and balance %.2f dollar\n", expense, user.getMoney() - expense);
        }
        user.setMoney(user.getMoney() - expense);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Food> foodList = generateMenu();
        User user = generateUser(in);
        user.introduce();
        userConsume(foodList, user, in);
        user.introduce();
        in.close();
    }
}
