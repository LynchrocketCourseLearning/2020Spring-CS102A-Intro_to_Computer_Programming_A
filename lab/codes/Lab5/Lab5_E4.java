import java.util.Scanner;
public class Lab5_E4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] a = new int[101];
        int i = -1;
        while (i != 0){
            i = sc.nextInt();
            a[i]++;
        }
        for(int b = 1; b < 101; b++){
            if (a[b] != 0){
                System.out.printf("%d occurs %d times \n", b, a[b]);
            }
        }
    }
}
