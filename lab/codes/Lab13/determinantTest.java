public class determinantTest {
    public static int determinant(int[][] a) {
        int result = 0;
        if (a.length == 1 & a[0].length == 1) {
            return a[0][0];
        }
        if (a.length == 2 & a[0].length == 2) {
            return a[0][0] * a[1][1] - a[0][1] * a[1][0];
        }
        if (a.length > 2 & a[0].length > 2) {
            int[][] b = new int[a.length - 1][a[0].length - 1];
            for (int i = 0; i < a[0].length; i++) {
                for (int j = 0; j < b.length; j++) {
                    for (int k = 0; k < b[0].length; k++) {
                        if (k < i) {
                            b[j][k] = a[j + 1][k];
                        }
                        if (k >= i) {
                            b[j][k] = a[j + 1][k + 1];
                        }
                    }
                }
                result += (int) (Math.pow(-1, i + 1) * a[0][i] * determinant(b));
            }
        }
        return -1 * result;
    }

    public static void main(String[] args) {
        int[][] c = new int[][]{{1}};
        int[][] b = new int[][]{{1, 2, 3}, {3, 2, 1}, {2, 1, 3}};
        int[][] a = new int[][]{{1, 2, 3, 4, 1}, {0, -1, 2, 4, 2}, {0, 0, 4, 0, 0}, {-3, -6, -9, -12, 4}, {0, 0, 1, 1, 1}};
        System.out.print(determinant(a));
    }
}
