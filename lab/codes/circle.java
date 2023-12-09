import java.util.Scanner;
public class circle {
    public static void main(String[] args) {
        int[] aa = new int[8];
        int[] bb = new int[8];
        int[] cc = new int[4];
        int num = 0;

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int y1 = (a - a % 10000) / 10000;
        int y2 = (b - b % 10000) / 10000;

        for (int i = 0; i < 8; i++) {
            aa[i] = a % 10;
            a /= 10;
            bb[i] = b % 10;
            b /= 10;
        }

        int m1 = aa[3] * 10 + aa[2];
        int m2 = bb[3] * 10 + aa[2];
        int d1 = aa[1] * 10 + aa[0];
        int d2 = bb[1] * 10 + bb[0];

        for (int i = y1; i <= y2; i++) {
            int x = i;
            for (int j = 0; j < 4; j++) {
                cc[j] = x % 10;
                x /= 10;
            }
            int mon = cc[0] * 10 + cc[1];
            int day = cc[2] * 10 + cc[3];
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