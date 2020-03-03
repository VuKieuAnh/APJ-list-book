package book;

public class FictionBook extends Book {
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public FictionBook(String name, double price) {
        super(name, price);
    }

    public FictionBook() {

    }
}
