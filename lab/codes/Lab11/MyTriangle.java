import java.lang.Math;
import java.util.Scanner;

public class MyTriangle {
    public static double perimeter(double a, double b, double c) {
        return a + b + c;
    }

    public static double area(double a, double b, double c) {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public static double area(double bottom, double height) {
        return 0.5 * bottom * height;
    }

    public static double area(double a, double b, int angel) {
        double c = Math.toRadians(angel);
        return 0.5 * a * b * Math.sin(c);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = 0, b, c;
        while (a != -1) {
            System.out.println("Please input three numbers");
            a = sc.nextDouble();
            if (a == -1) {
                System.out.println("Bye~");
                break;
            }
            b = sc.nextDouble();
            c = sc.nextDouble();
            double integer = Math.max(a, b);
            double max = Math.max(integer, c);
            if (max >= (a + b + c - max)) {
                System.out.println("The input is invalid");
                continue;
            }
            System.out.printf("The area is %.3f\n", area(a, b, c));
            System.out.printf("The perimeter is %.3f\n", perimeter(a, b, c));
        }
    }
}
