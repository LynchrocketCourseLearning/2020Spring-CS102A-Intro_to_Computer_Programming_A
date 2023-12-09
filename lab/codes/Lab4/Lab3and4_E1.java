public class Lab3and4_E1 {
    public static void main(String[] args){
        int row = 1;
        int res = 0;
        while(row <= 9){
            int col = 1;
            while(col <= row){
                res = col * row;
                System.out.printf("%2d * %2d = %2d", col, row, res);
                if(col == row){
                    System.out.print("\n");
                }
                col ++;
            }
            row ++;
        }

    }

}