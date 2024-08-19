import java.util.Scanner;
public class assignment2_5 {
    public static void main(String[] args){
        int n = 1;

        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();

        long[] a = new long[l];
        int[] s = new int[10000];

        for(int i = 0; i < l; i++){
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < l - 1; i++) {
            if (a[i] <= a[i + 1]) {
                n += 1;
            } else {
                s[n] = i;
                n = 1;
            }
        }

        for (int i = 9999; i >= 0; --i) {
            if (s[i] != 0) {
                for (int j = s[i] - i + 1; j <= s[i]; j++) {
                    System.out.print(a[j] + " ");
                }
                break;
            }
        }
    }
}
