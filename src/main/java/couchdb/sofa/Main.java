package couchdb.sofa;

import com.google.common.collect.Lists;
import java.util.Date;
import java.util.HashMap;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: michal
 * Date: 10/14/13
 * Time: 9:44 PM
 */
public class Main {

    public static void main(String[] args) {
        new Main().couchMe();
    }

    private void couchMe() {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("couchdb-and-java.xml");

        SofaRepository sofaRepository = (SofaRepository) context.getBean("sofaRepository");

        Sofa sofa = sofaRepository.get("f99d8a4d001a7ba547d1056d83000893");

        System.out.println(sofa);

        sofa.setSeats(3);
        sofa.setDateCreated(new Date());
        sofa.setImageURLs(Lists.newArrayList("ala", "ma", "kota"));
        HashMap<String, Pillow> pillows = new HashMap<String, Pillow>();
        pillows.put("pillow 1", new Pillow(Pillow.Softness.FIRM));
        pillows.put("pillow 2", new Pillow(Pillow.Softness.FIRM));
        pillows.put("pillow 3", new Pillow(Pillow.Softness.FIRM));
        sofa.setPillows(pillows);

        sofaRepository.update(sofa);

    }

}
