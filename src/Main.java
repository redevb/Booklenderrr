import java.io.IOException;
import kg.java.lesson44.Lesson44Server;

public class Main {
    public static void main(String[] args) {
        try {
            new Lesson44Server("localhost", 8881).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}