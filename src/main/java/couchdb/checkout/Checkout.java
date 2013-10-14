package couchdb.checkout;

import org.ektorp.support.CouchDbDocument;

/**
 * Created with IntelliJ IDEA.
 * User: michal
 * Date: 10/14/13
 * Time: 11:17 PM
 */
public class Checkout extends CouchDbDocument {

    private String day;

    private Integer checkout;


    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Integer getCheckout() {
        return checkout;
    }

    public void setCheckout(Integer checkout) {
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return "Checkout{" +
                "day='" + day + '\'' +
                ", checkout=" + checkout +
                '}';
    }
}
