import java.util.Scanner;
public class assignment3_1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        long[][] ab = new long[2*a][2*b];

        for(int i = 0; i < a; i++){
            for(int k = 0; k < b; k++){
                ab[i][k] = sc.nextLong();
                ab[2*a-1-i][k] = ab[i][k];
                ab[i][2*b-1-k] = ab[i][k];
                ab[2*a-1-i][2*b-1-k] = ab[i][k];
            }
        }

        for(int i = 0; i < 2*a; i++){
            for(int k = 0; k < 2*b; k++){
                System.out.print(ab[i][k] + " ");
            }
            System.out.println();
        }
    }
}
