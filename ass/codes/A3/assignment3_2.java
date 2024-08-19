import java.util.Scanner;

public class assignment3_2 {
    public static void main(String[] args) {
        int x;
        int y;

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[][] ab = new String[n][n];
        int[][] judge = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ab[i][j] = sc.next();
            }
        }

        int count1 = 1;
        int count2 = 1;
        int count3 = 1;
        int count4 = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (ab[i][j].equals("O")) {
                    int store1 = i;
                    int store2 = j;

                    int p = 1;
                    while (i + p <= n - 1 && ab[i][j].equals(ab[i + p][j])) {
                        count1++;
                        p++;
                    }
                    i = store1;
                    j = store2;
                    p = 1;
                    while (i - p >= 0 && ab[i][j].equals(ab[i - p][j])) {
                        count1++;
                        p++;
                    }
                    if (count1 >= 4) {
                        for (int k1 = 0; k1 < n; k1++) {
                            if (ab[k1][j].equals("N")) {
                                ab[k1][j] = "O";
                                x = k1;
                                y = j;
                                int co = 1;
                                for (int l = 0; l < n; l++) {
                                    if (ab[l][j].equals("O")) {
                                        co += 1;
                                    } else {
                                        co = 0;
                                    }
                                    if (co == 5) {
                                        judge[x][y] = 1;
                                        break;
                                    }
                                }
                                ab[k1][j] = "N";
                            }
                        }
                    }
                    i = store1;
                    j = store2;


                    int q = 1;
                    while (j + q <= n - 1 && ab[i][j].equals(ab[i][j + q])) {
                        count2++;
                        q++;
                    }
                    i = store1;
                    j = store2;
                    q = 1;
                    while (j - q >= 0 && ab[i][j].equals(ab[i][j - q])) {
                        count2++;
                        q++;
                    }
                    if (count2 >= 4) {
                        for (int k2 = 0; k2 < n; k2++) {
                            if (ab[i][k2].equals("N")) {
                                ab[i][k2] = "O";
                                x = i;
                                y = k2;
                                int co = 1;
                                for (int l = 0; l < n; l++) {
                                    if (ab[i][l].equals("O")) {
                                        co += 1;
                                    } else {
                                        co = 0;
                                    }
                                    if (co == 5) {
                                        judge[x][y] = 1;
                                        break;
                                    }
                                }
                                ab[i][k2] = "N";
                            }
                        }
                    }
                    i = store1;
                    j = store2;


                    int l = 1;
                    while (i + l <= n - 1 && j + l <= n - 1 && ab[i][j].equals(ab[i + l][j + l])) {
                        count3++;
                        q++;
                    }
                    i = store1;
                    j = store2;
                    l = 1;
                    while (i - l >= 0 && j - l >= 0 && ab[i][j].equals(ab[i - l][j - l])) {
                        count3++;
                        q++;
                    }
                    int row = i;
                    if (count3 >= 4) {
                        for (int k3 = 0; row < n && k3 < n; k3++, row++) {
                            if (ab[row][k3].equals("N")) {
                                ab[row][k3] = "O";
                                x = row;
                                y = k3;
                                int co = 1;
                                for (int f = 0; row < n && f < n; f++, row++) {
                                    if (ab[row][f].equals("O")) {
                                        co += 1;
                                    } else {
                                        co = 0;
                                    }
                                    if (co == 5) {
                                        judge[x][y] = 1;
                                        break;
                                    }
                                }
                                ab[row][k3] = "N";
                            }
                        }
                    }
                    i = store1;
                    j = store2;


                    int k = 1;
                    while (i - k >= 0 && j + k <= n - 1 && ab[i][j].equals(ab[i - k][j + k])) {
                        count4++;
                        q++;
                    }
                    i = store1;
                    j = store2;
                    k = 1;
                    while (i + k <= n - 1 && j - k >= 0 && ab[i][j].equals(ab[i + k][j - k])) {
                        count4++;
                        q++;
                    }
                    int col = j;
                    if (count4 >= 4) {
                        for (int k4 = 0; col < n && k4 < n; k4++, col++) {
                            if (ab[k4][col].equals("N")) {
                                ab[k4][col] = "O";
                                x = k4;
                                y = col;
                                int co = 1;
                                for (int f = 0; col < n && f < n; f++, col++) {
                                    if (ab[f][col].equals("O")) {
                                        co += 1;
                                    } else {
                                        co = 0;
                                    }
                                    if (co == 5) {
                                        judge[x][y] = 1;
                                        break;
                                    }
                                }
                                ab[k4][col] = "N";
                            }
                        }
                    }
                    i = store1;
                    j = store2;
                }
            }
        }
        boolean win = false;
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (judge[i][j]==1){
                    win = true;
                    System.out.printf("(%d,%d)\n",j+1,i+1);
                }
            }
        }
        if(win){
            System.out.println("No");
        }

    }
}
