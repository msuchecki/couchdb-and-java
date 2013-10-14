package couchdb.sofa;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created with IntelliJ IDEA.
 * User: michal
 * Date: 10/14/13
 * Time: 10:47 PM
 */
public class Pillow {

    public enum Softness {SOFT, MEDIUM, FIRM}

    private final Softness softness;

    @JsonCreator
    public Pillow(@JsonProperty("softness") Softness s) {
        softness = s;
    }

    public Softness getSoftness() {
        return softness;
    }

}
