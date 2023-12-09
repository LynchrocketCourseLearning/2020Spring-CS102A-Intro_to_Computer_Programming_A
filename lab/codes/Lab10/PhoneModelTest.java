import java.util.Scanner;

public class PhoneModelTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Your budget: ");
        int a = sc.nextInt();
        if (a <= 5588) {
            System.out.printf("You do have sufficient money");
        }
        for (PhoneModel model : PhoneModel.values()) {
            if (a >= model.getPrice()) {
                System.out.printf("%-10s", model);
                System.out.printf("price: %s\n", model.getPrice());
            }
        }
    }
}
