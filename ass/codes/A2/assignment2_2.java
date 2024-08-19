import java.util.Scanner;
public class assignment2_2 {
    public static void main(String[] args) {
        int n;
        int m;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[m];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        int j = 0;
        boolean jd1 = false;
        for (int i = 0; i < n; i++) {
            boolean jd2 = false;
            while(j < m){
                if(a[i] == b[j]){
                    jd2 = true;
                    j++;
                    break;
                }else{
                    j++;
                }
            }
            if(!jd2){
                jd1 = false;
                break;
            }else{
                jd1 = true;
            }
        }

        if(jd1){
            System.out.print("Yes");
        }else{
            System.out.print("No");
        }
    }
}

