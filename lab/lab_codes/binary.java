import java.util.Scanner;
import java.util.Stack;
public class binary {
    public static void main(String[] args) {
        long sum1 = 0, sum2 = 0, sum;
        long num1, num2;
        int x, y;
        int p, q;

        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        Scanner sc = new Scanner(System.in);

        num1 = sc.nextLong();
        num2 = sc.nextLong();

        while (num1 != 0) {
            x = (int) num1 % 10;
            num1 /= 10;
            st1.push(x);
        }
        while (num2 != 0) {
            y = (int) num2 % 10;
            num2 /= 10;
            st2.push(y);
        }

        while (st1.size() > 0) {
            p = st1.pop();
            sum1 += p * Math.pow(2, st1.size());
        }
        while (st2.size() > 0) {
            q = st2.pop();
            sum2 += q * Math.pow(2, st2.size());
        }
        sum = sum1 + sum2;

        int t = 0;
        long fsum = 0;
        long r;
        while(sum != 0){
            r = sum % 2;
            sum /= 2;
            fsum += r * Math.pow(10,t);
            t++;
        }
        System.out.print(fsum);
    }
}