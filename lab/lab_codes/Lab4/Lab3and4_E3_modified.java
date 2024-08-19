import java.util.Scanner;
public class Lab3and4_E3_modified {
        public static void main(String[] args) {
            double pi = 0;
            double last_pi = 1;
            int i = 1;
            double n = 0;

            System.out.println("Please input the precision: ");
            Scanner sc = new Scanner(System.in);
            n = sc.nextDouble();

            while(Math.abs(last_pi - pi) > n){
                last_pi = Math.abs(pi);
                if(i % 2 ==0) {
                    pi -= (double) 4 / (2 * i - 1);
                }else{
                    pi += (double) 4 / (2 * i - 1);
                }
                i++;
            }
            System.out.println("The estimation of pi is " + pi);
            System.out.printf("It computed %d times", i);
        }

}
