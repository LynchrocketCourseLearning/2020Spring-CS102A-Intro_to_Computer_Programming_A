import java.util.Scanner;

public class assignment1_2 {
    public static void main(String[] args){
        int x;
        int y;
        char direc;

        Scanner input = new Scanner(System.in);

        x = input.nextInt();
        y = input.nextInt();
        direc = input.next().charAt(0);

        while(direc != 'E') {
            if (direc == 'a') {
                x = x - 1;
            } else if (direc == 'd') {
                x = x + 1;
            } else if (direc == 's') {
                y = y - 1;
            } else if (direc == 'w') {
                y = y + 1;
            }
            direc = input.next().charAt(0);
        }
        {
            System.out.printf("%d %d",x, y);
        }

    }

}
