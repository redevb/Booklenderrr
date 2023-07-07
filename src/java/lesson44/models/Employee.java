package java.lesson44.models;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private int age;
    private int experience;
    private List<String> takenBooks = new ArrayList<>();
    private List<String> readsNow = new ArrayList<>();

    public Employee(String name, int age, int experience,List<String> takenBooks, List<String> readsNow) {
        this.name = name;
        this.age = age;
        this.experience = experience;
        this.takenBooks = takenBooks;
        this.readsNow = readsNow;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public List<String> getTakenBooks() {
        return takenBooks;
    }

    public void setTakenBooks(List<String> takenBooks) {
        this.takenBooks = takenBooks;
    }

    public List<String> getReadsNow() {
        return readsNow;
    }

    public void setReadsNow(List<String> readsNow) {
        this.readsNow = readsNow;
    }
}