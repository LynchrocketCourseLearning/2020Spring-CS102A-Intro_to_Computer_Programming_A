import java.util.Scanner;

public class Lab2_E2{
    public static void main(String []args){
        double width = 0;
        double height = 0;
        double area = 0;
        double perimeter = 0;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the width of a rectangle: ");
        width = input.nextDouble();
        System.out.print("Enter the height of a rectangle: ");
        height = input.nextDouble();

        area = width * height;
        perimeter = 2*(width + height);

        System.out.printf("The area is %.2f",area);
        System.out.printf("The perimeter is %.2f",perimeter);

    }
}