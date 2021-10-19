import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

class Area {
    protected int left, right;

    Area() {
        this(0, 0);
    }

    Area(int left, int right) {
        this.left = left;
        this.right = right;
    }
}

public class Main extends Area {
    private static Integer L;

    // private static HashSet<Area> treeSet = new HashSet<Area>();

    // // private static bool in()

    // private static void removeArea(Integer left, Integer right) {
    // for (Area treeArea : treeSet) {
    // if (treeArea.left < left && treeArea.right > right) {
    // treeArea.right = left - 1;
    // treeSet.add(new Area(right + 1, treeArea.right));
    // continue;
    // }else if(left < treeArea.left && right >= )

    // }
    // }

    public static void main(String argv[]) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        // treeSet.add(new Area(0, L));
        Boolean[] tree = new Boolean[L + 1];
        Arrays.fill(tree, true);
        Integer n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            Integer left = sc.nextInt(), right = sc.nextInt();
            // removeArea(left, right);
            for (int j = Math.max(left, 0); j <= right && j <= L; j++)
                tree[j] = false;
        }
        int count = 0;
        for (Boolean i : tree)
            if (i)
                count++;
        System.out.println(count);
        sc.close();
    }
}