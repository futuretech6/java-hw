import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String argv[]) {
        Scanner sc = new Scanner(System.in);
        Integer N = sc.nextInt(), K = sc.nextInt();
        ArrayList<Integer> L = new ArrayList<Integer>();
        for (Integer i = 0; i < N; i++)
            L.add(sc.nextInt());
        sc.close();

        Integer sum = 0;
        for (Integer d : L)
            sum += d;

        Integer Len = sum / K;
        while (true) {
            int rope = 0;
            for (Integer l : L)
                rope += l / Len;
            if (rope >= K) {
                System.out.println(Len);
                return;
            }
            Len--;
        }
    }
}
