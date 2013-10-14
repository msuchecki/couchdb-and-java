package couchdb.sofa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.ektorp.support.CouchDbDocument;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: michal
 * Date: 10/14/13
 * Time: 9:37 PM
 */

public class Sofa extends CouchDbDocument {

    private String color;
    private int seats;
    private Date dateCreated;
    private List<String> imageURLs;
    private Map<String, Pillow> pillows;


    public void setColor(String s) {
        this.color = s;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int i) {
        this.seats = i;
    }

    public String getColor() {
        return color;
    }

    public List<String> getImageURLs() {
        return imageURLs;
    }

    public void setImageURLs(List<String> imageURLs) {
        this.imageURLs = imageURLs;
    }

    @JsonIgnore
    public int getNumberOfImages() {
        return imageURLs != null ? imageURLs.size() : 0;
    }

    public Map<String, Pillow> getPillows() {
        return pillows;
    }

    public void setPillows(Map<String, Pillow> pillows) {
        this.pillows = pillows;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "Sofa{" +
                "color='" + color + '\'' +
                ", seats=" + seats +
                ", dateCreated=" + dateCreated +
                ", imageURLs=" + imageURLs +
                ", pillows=" + pillows +
                '}';
    }

    public static class SofaBuilder {
        private Sofa sofa;

        private SofaBuilder() {
            sofa = new Sofa();
        }

        public SofaBuilder withColor(String color) {
            sofa.color = color;
            return this;
        }

        public SofaBuilder withSeats(int seats) {
            sofa.seats = seats;
            return this;
        }

        public SofaBuilder withDateCreated(Date dateCreated) {
            sofa.dateCreated = dateCreated;
            return this;
        }

        public SofaBuilder withImageURLs(List<String> imageURLs) {
            sofa.imageURLs = imageURLs;
            return this;
        }

        public SofaBuilder withPillows(Map<String, Pillow> pillows) {
            sofa.pillows = pillows;
            return this;
        }

        public static SofaBuilder sofa() {
            return new SofaBuilder();
        }

        public Sofa build() {
            return sofa;
        }
    }
}
