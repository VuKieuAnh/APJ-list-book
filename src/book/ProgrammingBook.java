package book;

public class ProgrammingBook extends Book {
    private String language;
    private String framework;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFramework() {
        return framework;
    }

    public void setFramework(String framework) {
        this.framework = framework;
    }

    public ProgrammingBook(String name, double price, String language) {
        super(name, price);
        this.language = language;
    }

    public ProgrammingBook() {
    }
}
