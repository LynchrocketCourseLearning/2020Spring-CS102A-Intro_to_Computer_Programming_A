import java.util.Scanner;

public class assignment2_1 {
    public static void main(String[] args){
        int n = 0;
        int m = 0;
        int r = 1;
        int p = 0;
        int q = 0;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        p = n;
        q = m;

        while(m != 0){
            r = n % m;
            n = m;
            m = r;
        }
        System.out.printf("%d %d",p / n , q / n);
    }
}
