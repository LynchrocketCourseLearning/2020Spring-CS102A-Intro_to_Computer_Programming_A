import java.util.Scanner;

public class Lab3and4_E5 {
    public static void main(String[] args){
        double gpa;
        int score;
        int credit = 0;
        int a;
        double tol_gpa = 0;
        double tol_credit = 0;

        Scanner sc = new Scanner(System.in);

            while (credit != -1) {
                credit = sc.nextInt();
                if(credit == -1){
                    break;
                }
                score = sc.nextInt();
                a = score / 10;

                switch (a) {
                    case 9:
                    case 10:
                        gpa = 4.0;
                        break;
                    case 8:
                        gpa = 3.0;
                        break;
                    case 7:
                        gpa = 2.0;
                        break;
                    case 6:
                        gpa = 1.0;
                        break;
                    default:
                        gpa = 0;
                        break;
                }
                tol_gpa += gpa * credit;
                tol_credit += credit;
            }

            System.out.printf("final gpa is %.1f\n", tol_gpa / tol_credit);

    }
}
