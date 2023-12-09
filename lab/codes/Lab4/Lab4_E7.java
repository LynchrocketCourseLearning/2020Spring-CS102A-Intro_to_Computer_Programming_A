import java.util.Scanner;

public class Lab4_E7 {
    public static void main(String[] args) {
        int res;
        int cot;

        Scanner sc = new Scanner(System.in);
        System.out.println("Please input a number to print the Multiplication Table [0 to terminate]:");
        cot = sc.nextInt();

        while (cot != 0) {
            if (cot > 0) {
                for (int row = 1;row <= cot; row++) {
                    for (int col = 1;col <= row; col++) {
                        res = col * row;
                        System.out.printf("%2d * %2d = %2d", col, row, res);
                        if (col == row) {
                            System.out.print("\n");
                        }
                    }
                }
                System.out.println("Please input a number to print the Multiplication Table [0 to terminate]:");
            cot = sc.nextInt();
            }
            if (cot < 0) {
                System.out.println("Please input a number between [1,9]");
                System.out.println("Please input a number to print the Multiplication Table [0 to terminate]:");
                cot = sc.nextInt();
            }
            if (cot == 0){
                break;
            }
        }

    }
}
