import java.util.Scanner;
public class Lab5_E3 {
    public static void main(String[] args) {
        int n;
        int water = 0;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int[] array = new int[n];

        for (int a = 0; a < n; a++) {
            array[a] = sc.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {
            int c1 = i;
            int c2 = i;
            int LeftMax = array[0];
            int RightMax = array[n - 1];

            while (c1 >= 0) {
                if (array[c1] > LeftMax) {
                    LeftMax = array[c1];
                }
                c1--;
            }

            while (c2 < n) {
                if (array[c2] > RightMax) {
                    RightMax = array[c2];
                }
                c2++;
            }

            if(Math.min(LeftMax, RightMax) > array[i]){
                water = water + Math.min(LeftMax, RightMax) - array[i];
            }
        }
        System.out.println(water);
    }
}


