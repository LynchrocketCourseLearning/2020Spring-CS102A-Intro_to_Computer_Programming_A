import java.util.Scanner;

public class assignment3_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] ab = new char[n][n];

        for (int i = 0; i < n; i++) {
            char[] a = sc.next().toCharArray();
            for (int j = 0; j < n; j++) {
                ab[i][j] = a[j];
                if (ab[i][j] == '*') {
                    ab[i][j] = 'F';
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                if (ab[i][j] == '-') {
                    if (i - 1 >= 0 && ab[i - 1][j] == 'F') {
                        count++;
                    }
                    if (j - 1 >= 0 && ab[i][j - 1] == 'F') {
                        count++;
                    }
                    if (i + 1 <= n - 1 && ab[i + 1][j] == 'F') {
                        count++;
                    }
                    if (j + 1 <= n - 1 && ab[i][j + 1] == 'F') {
                        count++;
                    }
                    if (i - 1 >= 0 && j - 1 >= 0 && ab[i - 1][j - 1] == 'F') {
                        count++;
                    }
                    if (i - 1 >= 0 && j + 1 <= n - 1 && ab[i - 1][j + 1] == 'F') {
                        count++;
                    }
                    if (i + 1 <= n - 1 && j - 1 >= 0 && ab[i + 1][j - 1] == 'F') {
                        count++;
                    }
                    if (i + 1 <= n - 1 && j + 1 <= n - 1 && ab[i + 1][j + 1] == 'F') {
                        count++;
                    }
                    ab[i][j] = (char) (count + '0');
                }
                System.out.print(ab[i][j]);
            }
            System.out.println();
        }
    }
}
