import java.util.ArrayList;
import java.util.List;

class Page {
    String content;

    public Page() {
        this.content = "";
    }

    public Page(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

public class Book {
    List<Page> pages;

    public Book() {
        this.pages = new ArrayList<>();
    }

    public void add(Page page) {
        pages.add(page);
    }

    public int countBlankPages() {
        int counter = 0;
        for (Page page : this.pages) {
            if (page.getContent().isEmpty()) {
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        Book book = new Book();
        book.add(new Page("Julcsi elso szep konyve"));
        book.add(new Page(""));
        book.add(new Page(""));
        System.out.println(book.countBlankPages());
    }
}