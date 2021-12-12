import java.util.stream.IntStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        if (a < 2) {
            a = 2;
        }
        System.out.println(IntStream.range(a, b).filter(i -> !IntStream.range(2, i).anyMatch(j -> i % j == 0)).sum());
        in.close();
    }
}