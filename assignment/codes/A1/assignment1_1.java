import java.util.Scanner;

    public class assignment1_1 {
        public static void main(String[] args){
            String name;
            long StudentID = 0;

            Scanner input = new Scanner(System.in);

            name = input.next();
            StudentID = input.nextLong();
            if(StudentID>=11500000 && StudentID<12100000){
                System.out.printf("%s, welcome to Baoneng City!",name);
            }else {
                System.out.println(StudentID);
            }
        }
    }
