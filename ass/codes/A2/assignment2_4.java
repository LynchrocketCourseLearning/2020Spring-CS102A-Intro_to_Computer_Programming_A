import java.util.Scanner;
public class assignment2_4 {
    public static void main(String[] args) {
        int[] l1 = new int[8];
        int[] l2 = new int[8];
        int[] ch = new int[4];
        int num = 0;

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int y1 = (a - a % 10000) / 10000;
        int y2 = (b - b % 10000) / 10000;

        for (int i = 0; i < 8; i++) {
            l1[i] = a % 10;
            a /= 10;
            l2[i] = b % 10;
            b /= 10;
        }

        int m1 = l1[3] * 10 + l1[2];
        int m2 = l2[3] * 10 + l1[2];
        int d1 = l1[1] * 10 + l1[0];
        int d2 = l2[1] * 10 + l2[0];

        for (int i = y1; i <= y2; i++) {
            int x = i;
            for (int j = 0; j < 4; j++) {
                ch[j] = x % 10;
                x /= 10;
            }

            int mon = ch[0] * 10 + ch[1];
            int day = ch[2] * 10 + ch[3];
            if (i == y1) {
                if (!((mon > m1) || (mon == m1 && day >= d1))) {
                    continue;
                }
            } else if (i == y2) {
                if (!((mon < m2) || (mon == m2 && day <= d2))) {
                    continue;
                }
            }
            if (mon >= 1 && mon <= 12) {
                if (mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8 || mon == 10 || mon == 12) {
                    if (day >= 1 && day <= 31) {
                        num++;
                    }
                } else if (mon == 2) {
                    if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                        if (day >= 1 && day <= 29) {
                            num++;
                        }
                    } else {
                        if (day >= 1 && day <= 28) {
                            num++;
                        }
                    }
                } else {
                    if (day >= 1 && day <= 30) {
                        num++;
                    }
                }
            }
        }
        System.out.print(num);
    }
}