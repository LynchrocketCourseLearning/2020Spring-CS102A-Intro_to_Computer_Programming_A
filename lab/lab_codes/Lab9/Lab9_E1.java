import java.io.File;

public class Lab9_E1 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\");
        String[] fileList = file.list();
        for (String name : fileList) {
            System.out.println(name);
        }
    }
}
