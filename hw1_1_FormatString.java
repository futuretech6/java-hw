import java.util.Scanner;

class w1_1 {
    public static void main(String args[]) {
        String selectType;
        Scanner in = new Scanner(System.in);
        while (true) {
            selectType = in.nextLine();
            if (selectType.equals("double")) {
                double[] ary = new double[3];
                for (int i = 0; i < 3; i++)
                    ary[i] = in.nextDouble();
                System.out.printf("choice=%s\n%-5.2f,%5.2f,%.2f\n", selectType, ary[0], ary[1], ary[2]);
                in.nextLine();
            } else if (selectType.equals("int")) {
                int sum = 0;
                for (int i = 0; i < 3; i++)
                    sum += in.nextInt();
                System.out.printf("choice=%s\n%d\n", selectType, sum);
                in.nextLine();
            } else if (selectType.equals("str")) {
                String[] ary;
                ary = in.nextLine().split("\\s+");
                System.out.printf("choice=%s\n%s%s%s\n", selectType, ary[2], ary[1], ary[0]);
            } else if (selectType.equals("line")) {
                String str;
                str = in.nextLine().toUpperCase();
                System.out.printf("choice=%s\n%s\n", selectType, str);
            } else {
                System.out.printf("choice=%s\nother", selectType);
                break;
            }
        }
        in.close();
    }
}

/*
double
1.578 3.0 3.14259
line
aaaaaaaaaa
int
1      2    3
str
321 654 987
line
dddddddddd
end



*/