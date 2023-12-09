import java.util.Scanner;
public class Lab5_E2 {
    public static void main(String[] args) {
        int len;

        System.out.print("Enter the length of array:");
        Scanner sa = new Scanner(System.in);
        len = sa.nextInt();
        int[] a = new int[len];
        int[] b = new int[len];

        System.out.printf("Enter the 1st integer array of size %d: ", len);
        Scanner sb = new Scanner(System.in);
        for (int i = 0; i < len; i++) {
            a[i] = sb.nextInt();
        }

        System.out.printf("Enter the 2nd integer array of size %d: ", len);
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < len; i++) {
            b[i] = sc.nextInt();
        }
        int p = 0;
        for (int i = 0; i < len; i++) {
            if (a[i] != b[i]) {
                p += 1;
            }
        }
        if(p > 0){
            System.out.println("The two arrays have different value");
        }else{
            System.out.println("The two arrays have the same value");
        }

    }
}
