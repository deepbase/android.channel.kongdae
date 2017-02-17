package music.domain;


import android.media.Image;

/**
 * Created by Joonki on 2017-01-06.
 */

public class Music {
    //
    private int numberOfGradings;
    private int sumOfGrades;

    private String composer;
    private String name;
    private String genre;
    private String instrument;
    private int compositionYear;

    private Image image;

    public Music() {
        //
    }

    public float getAverageGrade() {
        //
        return (float) sumOfGrades / (float) numberOfGradings;
    }

    public int getNumberOfGradings() {
        return numberOfGradings;
    }

    public void setNumberOfGradings(int numberOfGradings) {
        this.numberOfGradings = numberOfGradings;
    }

    public void setSumOfGrades(int sumOfGrades) {
        this.sumOfGrades = sumOfGrades;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public int getCompositionYear() {
        return compositionYear;
    }

    public void setCompositionYear(int compositionYear) {
        this.compositionYear = compositionYear;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
