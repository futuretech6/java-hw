import java.util.Scanner;

class w2_2 {
    public static void main(String args[]) {
        String str, query, target;
        Scanner in = new Scanner(System.in);
        str = in.nextLine();
        query = in.nextLine();
        target = in.nextLine();
        System.out.printf(str.replace(' ' + query, ' ' + target).replace(query + ' ', target + ' '));
        in.close();
    }
}

/*
 * Although I am without you, I will always be ou you ou with
 */