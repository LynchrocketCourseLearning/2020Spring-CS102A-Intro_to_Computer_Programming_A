import java.math.BigInteger;
import java.util.Scanner;
public class assignment2_3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        BigInteger num1 = new BigInteger(sc.next(), 2);
        BigInteger num2 = new BigInteger(sc.next(), 2);

        BigInteger sum = num1.add( num2 );

        System.out.print(sum.toString(2));
    }
}
