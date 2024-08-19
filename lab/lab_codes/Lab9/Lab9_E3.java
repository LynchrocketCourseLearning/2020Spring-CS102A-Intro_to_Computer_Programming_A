import java.io.*;
import java.util.Scanner;

public class Lab9_E3 {
    public static void main(String[] args) {
        try {
            BufferedReader file = new BufferedReader(new FileReader("TestIn.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("TestOut.txt"));

            Scanner sc = new Scanner(file);
            boolean ch = true;
            while (sc.hasNext()) {
                StringBuilder word = new StringBuilder(sc.next());
                if (ch) {
                    word.setCharAt(0, (char) (word.charAt(0) - 'a' + 'A'));
                }
                if (word.charAt(word.length() - 1) == '.' && word.charAt(0) >= 'a' && word.charAt(0) <= 'z') {
                    ch = true;
                } else {
                    ch = false;
                }

                writer.write(word.toString() + " ");
            }
            file.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("There is no this file!");
        }

    }
}
