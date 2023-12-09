import java.util.Scanner;
public class Lab3and4_E4 {
        public static void main(String[] args) {
            double pi = 0;
            int i = 1;
            int n = 0;

            System.out.println("Please input n: ");
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();

            for (i = 1; i <= n; i++){
                if(i % 2 ==0) {
                    pi = pi - (double) 4 / (2 * i - 1);
                }else{
                    pi = pi + (double) 4 / (2 * i - 1);
                }
            }
            System.out.println("The estimation of pi is "+ pi);
        }

    }

