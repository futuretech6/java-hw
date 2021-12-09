import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int max = 0;
        Scanner in = new Scanner(System.in);
        String line = in.nextLine(); // read a whole line in
        String[] a = line.split("\\s+"); // split the line according to space
        for (String s : a) { // iterate every word in the line
            s = s.toUpperCase(); // turn the whole word into upper case
            System.out.println(s); // print out the upper case word
            max = Integer.max(max, s.length()); // find the longest word
        }
        System.out.println(max);
        in.close();
    }
}