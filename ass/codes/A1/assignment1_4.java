import java.util.Scanner;
public class assignment1_4 {
    public static void main(String[] args){

        int T;
        long add = 0;
        long money;
        int i = 0;
        int a = 0;
        int b = 0;
        int c = 0;

        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        while (i < T) {
            money = sc.nextLong();
            add += money;
            if (money >= 5000 | add >= 3000 & T >= 10){
                a++;
            }else if (money >= 3000 | add >= 2000 & T >= 5){
                b++;
            }else if (money >= 1500 | add >= 1000 & T >= 3) {
                c++;
            }
            i++;
        }
        if(a > 0){
            System.out.print("Diamond");
        }else if(a == 0 & b > 0){
            System.out.print("Gold");
        }else if(b == 0 & c > 0){
            System.out.print("Silver");
        }else if (c == 0 & b == 0){
            System.out.print("Ordinary");
        }
    }
}
