package java;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import kg.attractor.java.lesson44.models.Book;
import kg.attractor.java.lesson44.models.Employee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class FileService {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path BOOKS_PATH = Paths.get("data/json/books.json");
    private static final Path EMPLOYEES_PATH = Paths.get("data/json/employees.json");

    public static Book[] readBooksFile(){
        String json;
        json = "";
        try {
            json = Files.readString(BOOKS_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return GSON.fromJson(json, Book[].class);
    }

    public static Employee[] readEmployeesFile(){
        String json;
        json = "";
        try {
            json = Files.readString(EMPLOYEES_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return GSON.fromJson(json, Employee[].class);
    }

    public static void writeToFile(List<Book> books){
        String json = GSON.toJson(books);
        try{
            Files.write(BOOKS_PATH, json.getBytes());
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

