import java.util.ArrayList;
import java.util.Scanner;

public class Lab8_E5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("s1: ");
        String str1 = input.nextLine();
        System.out.print("s2: ");
        String str2 = input.nextLine();
        int cnt = 0;

        ArrayList<Integer> list1 = new ArrayList<>();

        int index = 0;
        while (true) {
            int m = str1.indexOf(str2, index);
            if (m == -1) {
                break;
            }
            list1.add(m);
            index = m + 1;
            cnt++;
            System.out.println("Found at index: " + m);

        }
        System.out.println("Total occurrences: " + cnt);
    }
}
