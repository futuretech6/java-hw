import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    /* 请在这里填写答案 */

    public static ArrayList<Integer> pick(ArrayList<Integer> input) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = input.size() - 1; i >= 0; i--) { // important
            if (set.contains(input.get(i)))
                input.remove(i);
            else
                set.add(input.get(i));
        }

        Collections.sort(input, Collections.reverseOrder());

        return input;
    }

    /* 请在这里填写答案 */

    public static void main(String[] args) {
        ArrayList<Integer> lst = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            lst.add(in.nextInt());
        }
        lst = pick(lst);
        for (int x : lst) {
            System.out.print(x + " ");
        }
        System.out.println();
        in.close();
    }
}