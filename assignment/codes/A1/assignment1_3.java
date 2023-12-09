import java.util.Scanner;

public class assignment1_3 {
    public static void main(String[] args) {
        int h1;
        int h2;
        int m1;
        int m2;
        int s1;
        int s2;

        Scanner sc = new Scanner(System.in);

        h1 = sc.nextInt();
        m1 = sc.nextInt();
        s1 = sc.nextInt();
        h2 = sc.nextInt();
        m2 = sc.nextInt();
        s2 = sc.nextInt();

        int sec1 = h1 * 3600 + m1 * 60 + s1;
        int sec2 = h2 * 3600 + m2 * 60 + s2;
        int dm = (sec2 - sec1) / 60;
        int ds = sec2 - sec1 - dm * 60;

        if(dm == 0){
            System.out.printf("%ds",ds);
        }else if(ds == 0){
            System.out.printf("%dm",dm);
        }else{
            System.out.printf("%dm%ds",dm,ds);
        }
    }
}
