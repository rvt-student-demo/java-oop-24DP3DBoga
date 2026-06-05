package rvt.InterfaceInABox;

public class CD implements Packable {

    private String artist;
    private String name;
    private int pubYear;
    private double weight;

    public CD(String cdArtist, String cdName, int publicationYear) {
        this.artist = cdArtist;
        this.name = cdName;
        this.pubYear = publicationYear;
        this.weight = 0.1;
    }

    @Override
    public double weight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return this.artist + ": " + this.name + " (" + this.pubYear + ")";
    }
}