package kg.java.lesson44.models;

import kg.java.lesson44.FileService;
import java.util.ArrayList;
import java.util.List;

public class BookDataModel {
    private ArrayList<Book> books;
    public BookDataModel() {
        books = new ArrayList(List.of(FileService.readBooksFile()));
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
}
