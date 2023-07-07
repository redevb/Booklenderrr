package java.lesson44.models;

public class Book {
    private String id;
    private String name;
    private String author;
    private int year;
    private boolean isCoverSolid;
    private String genre;
    private String imgName;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getDate() {
        return year;
    }

    public void setDate(int year) {
        this.year = year;
    }

    public boolean getIsCoverSolid() {
        return isCoverSolid;
    }

    public void setCoverSolid(boolean coverSolid) {
        isCoverSolid = coverSolid;
    }
}
