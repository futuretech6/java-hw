import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, a, b, c;
        n = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        String target = genString(n);
        System.out.println(target.length() + " " + countNum(target.substring(a, b + 1), c));
        sc.close();
    }

    private static String genString(int n) {
        StringBuilder target = new StringBuilder("");
        for (int i = 0; i <= n; i++)
            target.append(i);
        return target.toString();
    }

    private static int countNum(String s, int n) {
        int cnt = 0;
        for (char i : s.toCharArray())
            if (i == n + '0')
                cnt++;
        return cnt;
    }
}

/*
 * 12 2 5 3
 */