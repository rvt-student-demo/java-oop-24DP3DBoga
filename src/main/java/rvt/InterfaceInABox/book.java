package rvt.InterfaceInABox;

public class Book implements Packable {

    private String author;
    private String name;
    private double weight;

    public Book(String author, String bookName, double bookWeight) {
        this.author = author;
        this.name = bookName;
        this.weight = bookWeight;
    }

    @Override
    public double weight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return this.author + ": " + this.name;
    }
}