import java.util.Scanner;
public class Lab6_E2 {
    public static void main(String[] args){
        double bottom, height;
        double a, b;
        int an;

        Scanner sc = new Scanner(System.in);

        System.out.println("Please input two numbers for bottom and height:");
        bottom = sc.nextDouble();
        height = sc.nextDouble();
        double ar1 = area1(bottom, height);
        System.out.print("The area is " + ar1);

        System.out.println("\nPlease input two numbers for a and b:");
        a = sc.nextDouble();
        b = sc.nextDouble();
        System.out.println("Please input a number in (0, 180) for angle (angle is an int variable)");
        an = sc.nextInt();
        double ar2 = area2(a, b, an);
        System.out.print("The area is " + ar2);
    }
    public static double area1(double bottom, double height) {
        double area1;
        area1 =(double) 1/2 * bottom* height;
        return area1;
    }
    public static double area2(double a, double b, int angleOfAandB) {
        double area2;
        double ang = (double) angleOfAandB * Math.PI / 180;
        area2 =(double) 1/2 * a* b* Math.sin(ang);
        return area2;
    }
}
