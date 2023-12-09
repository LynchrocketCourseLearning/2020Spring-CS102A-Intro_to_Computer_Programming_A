import java.util.Scanner;
public class Lab6_E4 {
    public static void main(String[] args){
        int g = 0;

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int[][] c = new int[a][b];

        for(int i = 0; i < a; i++){
            for(int k = 0; k < b; k++){
                c[i][k] = sc.nextInt();
            }
        }
        for(int i = 0; i < a; i++){
            boolean che = check(c, a, b);
            if(che){
                g += 1;
            }
        }
        g = g /a + 1;
        System.out.printf("There are %d bingo grids.", g);
    }

    public static boolean check(int[][] board, int row, int column){
        boolean chec = false;
        for(int i = 1; i < row-1; i++){
            for(int k = 1; k < column-1; k++){
                 if(board[i][k] == 0 & board[i-1][k] == 1 & board[i+1][k] == 1 & board[i][k-1] == 1 & board[i][k+1] == 1){
                    chec = true;
                }
            }
        }
        return chec;
    }
}