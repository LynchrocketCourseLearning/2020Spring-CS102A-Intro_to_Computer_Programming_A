import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Lab8_E4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int j = 1;
        while (j != 0) {
            System.out.print("Please type a string:");
            String check = sc.nextLine();
            if (check.equals(" ")) {
                System.out.println("Empty String, exit...");
                break;
            }
            char[] chrs = check.toCharArray();
            List<String> str = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < chrs.length; i++) {
                if (str.contains(String.valueOf(chrs[i]))) {
                    continue;
                } else {
                    str.add(String.valueOf(chrs[i]));
                    sb.append(String.valueOf(chrs[i]));
                }
            }
            String sa = sb.toString();
            String s = sa.replaceAll(" ","");
            System.out.println(s);
        }
    }
}
