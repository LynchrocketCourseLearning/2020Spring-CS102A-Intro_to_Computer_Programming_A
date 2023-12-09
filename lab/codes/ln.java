import java.util.Scanner;
public class ln {
    public static void main(String[] args){
       double p;
       double q;
       double l = 1000.5;
       double r;

       Scanner sc = new Scanner(System.in);
       p = sc.nextDouble();
       q = sc.nextDouble();

       r = Math.log(p / l) / Math.log(p / q);

       System.out.printf("%.2f", r);
    }
}
