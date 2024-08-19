import java.util.Scanner;
public class Lab5_E1 {
    public static void main(String[] args) {
        double[] sco = new double[10];

        double sum = 0;

        System.out.print("Please input 10 score of these students:");
        Scanner sc = new Scanner(System.in);

        for (int a = 0; a < 10; a++) {
            sco[a] = sc.nextDouble();
        }
        double max = sco[1];
        double min = sco[2];

        for (int a = 0; a < 10; a++){
            sum = sum + sco[a];
            if (sco[a] > max) {
                max = sco[a];
            }
            if (sco[a] < min) {
                min = sco[a];
            }
        }

        sum = sum - max - min;
        double ave = sum / 8;
        System.out.printf("Average score is %f", ave);
    }
}
