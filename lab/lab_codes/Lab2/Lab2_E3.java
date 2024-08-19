import java.util.Scanner;

public class Lab2_E3{
    public static void main(String []args){
        int sec, min, hour;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of seconds: ");
        sec = input.nextInt();
        hour = sec/3600;
        min = (sec - hour * 3600) / 60;
        sec = sec - min * 60 - hour * 3600;
        System.out.printf("The equivalent time is %d hours %d minutes %d seconds", hour, min, sec);

    }
}