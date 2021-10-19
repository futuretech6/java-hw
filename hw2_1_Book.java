import java.util.*;

class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<Book>();
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            String str = in.nextLine();
            String[] data = str.split(",");
            Book book = new Book(data[0], Integer.parseInt(data[1]), data[2], Integer.parseInt(data[3]));
            books.add(book);
        }

        System.out.println(totalprice(books));
    }

    /* 计算所有book的总价 */
    public static int totalprice(List<Book> books) {
        int result = 0;
        for (int i = 0; i < books.size(); i++) {
            result += books.get(i).getPrice();
        }
        return result;
    }
}

/* 请在这里填写答案 */

class Book {
    private String name, author;
    private int price, year;

    public Book(String name, int price, String author, int year) {
        this.name = name;
        this.price = price;
        this.author = author;
        this.year = year;
    }

    public int getPrice() {
        return this.price;
    }
}