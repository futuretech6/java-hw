import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String[]> lst = new ArrayList<String[]>();

        while (in.hasNextLine()) {
            String line = in.nextLine();
            lst.add(line.split(" "));
        }
        Set<String> ret = lst.stream().filter(i -> i[0].equals("the")).map(i -> i[i.length - 1])
                .collect(Collectors.toSet());
        ArrayList<String> r = new ArrayList<String>(ret);
        Collections.sort(r);
        for (String s : r) {
            System.out.println(s);
        }
        in.close();
    }
}