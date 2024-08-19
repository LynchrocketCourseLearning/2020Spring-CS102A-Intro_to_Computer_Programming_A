import java.util.Scanner;
public class Lab5_E5 {
    public static void main(String[] args) {
        int cNum, sNum;
        int i, j;
        int total = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the number of subjects: ");
        cNum = input.nextInt();
        System.out.print("Please enter the number of students: ");
        sNum = input.nextInt();
        int[][] table = new int[cNum][sNum];
        for (i = 0; i <= cNum - 1; i++){
            for (j = 0; j <= sNum - 1; j++)
                table[i][j] = input.nextInt();
        }
        double[] averageCourse = new double [cNum];
        double[] averageStudent = new double [sNum];
        for (i = 0; i <= cNum - 1; i++){
            for (j = 0; j <= sNum - 1; j++)
                total = total + table[i][j];
            averageCourse[i] = (double)total/sNum;
            total = 0;
        }
        for (i = 0; i <= sNum - 1; i++){
            for (j = 0; j <= cNum - 1; j++)
                total = total + table[j][i];
            averageStudent[i] = (double)total/cNum;
            total = 0;
        }
        for (i = 1; i <= cNum; i++)
            System.out.printf("Course%d  ", i);
        System.out.println("Average");
        for (i = 0; i <= sNum - 1; i++){
            System.out.printf("Student%d  ", i);
            for (j = 0; j <= cNum - 1; j++)
                System.out.printf("  %d  ", table[j][i]);
            System.out.printf("  %.2f", averageStudent[i]);
            System.out.println();
        }
        System.out.print("Average  ");
        for (i = 0; i< cNum; i++)
            System.out.printf("  %.2f  ", averageCourse[i]);
    }
}
