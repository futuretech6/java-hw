import java.util.Scanner;

/**
 * 代码中向系统申请资源，到最后都要将资源释放。
 * 
 * 现有一Resource类代表资源类，包含方法：
 * 
 * open(String str)打开资源，声明为抛出Exception(包含出错信息)。
 * 
 * close()方法释放资源，声明为抛出RuntimeException(包含出错信息)
 * 
 * 现在根据open(String str)中str的不同，打印不同的信息。str的内容分为4种情况：
 * 
 * 
 * 
 * fail fail，代表open和close均会出现异常。打印open的出错信息与close的出错信息。
 * 
 * fail success，代表open抛出异常，打印open出错信息。close正常执行，打印resource release success
 * 
 * success fail ,代表open正常执行，打印resource open success。close抛出异常，打印close出错信息。
 * 
 * success success，代表open正常执行，打印resource open success，close正常执行打印resource
 * release success。
 * 
 * 注1：你不用编写打印出错信息的代码。
 * 
 * 注2：捕获异常后使用System.out.println(e)输出异常信息，e是所产生的异常。
 */

class Resource {
    public void open(String str) {
    }

    public void close() {
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Resource resource = null;
        try {
            resource = new Resource();
            resource.open(sc.nextLine());
            /* 这里放置你的答案 */

            System.out.println("resource open success");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                resource.close();
                System.out.println("resource release success");
            } catch (RuntimeException e) {
                System.out.println(e);
            }
        }

        /* 这里放置你的答案 */

        sc.close();

    }
}
