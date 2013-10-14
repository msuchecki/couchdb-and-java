package couchdb.sofa;

import com.google.common.collect.Lists;
import org.ektorp.Options;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.HashMap;

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
//
//        Sofa sofa = Sofa.SofaBuilder.sofa()
//                .withColor("black")
//                .build();
//
//
//        sofaRepository.add(sofa);

        Options options = new Options().param("paramName","paramValue");
        Sofa sofa = sofaRepository.get("20e067cfe38852a9f4433dbe050001ed");

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


//        Sofa sofa = sofaRepository.get("20e067cfe38852a9f4433dbe050001ed", new Options().includeRevisions());
//        System.out.println(sofa);
//        System.out.println(sofa.getRevisions());

    }

}
