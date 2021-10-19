import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String argv[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer> P = new ArrayList<Integer>();
        for (int i = 0; i < N; i++)
            P.add(sc.nextInt());
        sc.close();

        Collections.sort(P);
        // for (int i : P)
        //     System.out.print(i + " ");

        int count = 0, state = 1, prev = -1; // 1 sep from '1'
        for (int i : P) {
            if (i == prev + 1)
                state++;
            if (state == 3) {
                state = 1;
                prev = -1;
                count++;
            }
            prev = i;
            // System.out.println(state);
        }
        System.out.println(count);
    }
}
