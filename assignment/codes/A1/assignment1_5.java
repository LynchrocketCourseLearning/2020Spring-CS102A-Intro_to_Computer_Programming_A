import java.util.Scanner;

public class assignment1_5 {
    public static void main(String[] args){
        int ty;
        char lev;
        double pri;
        int n;
        double tol = 0;
        double money = 0;

        Scanner sc = new Scanner(System .in);

        ty = sc.nextInt();
        lev = sc.next().charAt(0);

        for(int i = 0; i < ty; i++) {
            pri = sc.nextDouble();
            n = sc.nextInt();
            tol = tol + pri * n;
        }
            if (lev == 'D') {
                money = 0.7 * tol;
            }else if(lev == 'G'){
                money = 0.8 * tol;
            }else if(lev == 'S'){
                money = 0.9 * tol;
            }else if(lev == 'O'){
                money = 1 * tol;
            }
        System.out.printf("%.1f",money);
    }
}
