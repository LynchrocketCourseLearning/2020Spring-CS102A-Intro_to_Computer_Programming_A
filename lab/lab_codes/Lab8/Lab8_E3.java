import java.util.Scanner;
public class Lab8_E3 {
    public static void main(String[] args){
        System.out.print("Type a string (\"quit\" to finish): ");
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        while(!a.equals("quit")){
            StringBuilder b = new StringBuilder(a);
            String c = String.valueOf(b.reverse());
            if(a.equalsIgnoreCase(c)){
                System.out.printf("%s is a palindrome\n", a);
            }else{
                System.out.printf("%s is not a palindrome\n", a);
            }
            System.out.print("Type a string (\"quit\" to finish): ");
            a = sc.next();
        }

    }
}

