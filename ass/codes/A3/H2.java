import java.util.Scanner;

public class H2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] judge = new int[n][n];
        String[][] ab = new String[n][n];
        int x, y;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ab[i][j] = sc.next();
            }
        }
        for (int i = 0; i < n; i++) {
            int jud = 0;
            for (int j = 0; j < n; j++) {
                if (ab[i][j].equals("O")) {
                    jud += 1;
                }
            }
            if (jud >= 4) {
                for (int j = 0; j < n; j++) {
                    if (ab[i][j].equals("N")) {
                        ab[i][j] = "O";
                        x = i;
                        y = j;
                        int co = 0;
                        for (int h = 0; h < n; h++) {
                            if (ab[i][h].equals("O")) {
                                co += 1;
                            } else {
                                co -= 5;
                                if (co < 0) {
                                    co = 0;
                                }
                            }
                            if (co == 5) {
                                judge[x][y] = 1;
                                break;
                            }
                        }
                        ab[i][j] = "N";
                    }
                }
            }
        }

        for (int j = 0; j < n; j++) {
            int jud = 0;
            for (int i = 0; i < n; i++) {
                if (ab[i][j].equals("O")) {
                    jud += 1;
                }
            }
            if (jud >= 4) {
                for (int i = 0; i < n; i++) {
                    if (ab[i][j].equals("N")) {
                        ab[i][j] = "O";
                        x = i;
                        y = j;
                        int co = 0;
                        for (int h = 0; h < n; h++) {
                            if (ab[h][j].equals("O")) {
                                co += 1;
                            } else {
                                co -= 5;
                                if (co < 0) {
                                    co = 0;
                                }
                            }
                            if (co == 5) {
                                judge[x][y] = 1;
                                break;
                            }
                        }
                        ab[i][j] = "N";
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int jud = 0, row = i;
            for (int j = 0; row < n && j < n && n - i >= 5; j++, row++) {
                if (ab[row][j].equals("O")) {
                    jud += 1;
                }
            }
            row = i;
            if (jud >= 4) {
                for (int j = 0; row < n && j < n; j++, row++) {
                    if (ab[row][j].equals("N")) {
                        ab[row][j] = "O";
                        x = row;
                        y = j;
                        int co = 0, row1 = i;
                        for (int h = 0; row1 < n && h < n; h++, row1++) {
                            if (ab[row1][h].equals("O")) {
                                co += 1;
                            } else {
                                co -= 5;
                                if (co < 0) {
                                    co = 0;
                                }
                            }
                            if (co == 5) {
                                judge[x][y] = 1;
                                break;
                            }
                        }
                        ab[row][j] = "N";
                    }
                }
            }
        }
        for (int j = 1; j < n; j++) {
            int jud = 0, col = j;
            for (int i = 0; col < n && i < n && n - j >= 5; i++, col++) {
                if (ab[i][col].equals("O")) {
                    jud += 1;
                }
            }
            col = j;
            if (jud >= 4) {
                for (int i = 0; col < n && i < n; i++, col++) {
                    if (ab[i][col].equals("N")) {
                        ab[i][col] = "O";
                        x = i;
                        y = col;
                        int co = 0, col1 = j;
                        for (int h = 0; col1 < n && h < n; h++, col1++) {
                            if (ab[h][col1].equals("O")) {
                                co += 1;
                            } else {
                                co -= 5;
                                if (co < 0) {
                                    co = 0;
                                }
                            }
                            if (co == 5) {
                                judge[x][y] = 1;
                                break;
                            }
                        }
                        ab[i][col] = "N";
                    }
                }
            }
        }

        for (int j = n - 1; j >= 0; j--) {
            int jud = 0, row = j;
            for (int i = 0; row >= 0 && i < n && j + 1 >= 5; i++, row--) {
                if (ab[i][row].equals("O")) {
                    jud += 1;
                }
            }
            row = j;
            if (jud >= 4) {
                for (int i = 0; row >= 0 && j < n; i++, row--) {
                    if (ab[i][row].equals("N")) {
                        ab[i][row] = "O";
                        x = i;
                        y = row;
                        int co = 0, row1 = j;
                        for (int h = 0; row1 >= 0 && h < n; h++, row1--) {
                            if (ab[h][row1].equals("O")) {
                                co += 1;
                            } else {
                                co -= 5;
                                if (co < 0) {
                                    co = 0;
                                }
                            }
                            if (co == 5) {
                                judge[x][y] = 1;
                                break;
                            }
                        }
                        ab[i][row] = "N";
                    }
                }
            }
        }
        for (int i = 1; i < n; i++) {
            int jud = 0, row = i;
            for (int j = n - 1; row < n && j >= 0 && n - i >= 5; j--, row++) {
                if (ab[row][j].equals("O")) {
                    jud += 1;
                }
            }
            row = i;
            if (jud >= 4) {
                for (int j = n - 1; row < n && j >= 0; j--, row++) {
                    if (ab[row][j].equals("N")) {
                        ab[row][j] = "O";
                        x = row;
                        y = j;
                        int co = 0, row1 = i;
                        for (int h = n - 1; row1 < n && h >= 0; h--, row1++) {
                            if (ab[row1][h].equals("O")) {
                                co += 1;
                            } else {
                                co -= 5;
                                if (co < 0) {
                                    co = 0;
                                }
                            }
                            if (co == 5) {
                                judge[x][y] = 1;
                                break;
                            }
                        }
                        ab[row][j] = "N";
                    }
                }
            }
        }

        boolean win = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (judge[i][j] == 1) {
                    win = false;
                    System.out.printf("(%d,%d)\n", j + 1, i + 1);
                }
            }
        }
        if (win) {
            System.out.println("No");
        }
    }
}