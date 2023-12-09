import java.util.Scanner;
public class Lab6_E3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(fibonacci(n));
    }

    public static int fibonacci(int n){
       if(n == 1){
           return 1;
       }else if(n == 2){
           return 1;
       }else{
           return (fibonacci(n - 1) + fibonacci(n - 2));
       }
    }
}
