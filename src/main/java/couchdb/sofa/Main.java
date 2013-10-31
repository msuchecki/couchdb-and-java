package couchdb.sofa;

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

        Sofa sofa = Sofa.SofaBuilder.sofa()
                .withColor("black")
                .build();


        sofaRepository.add(sofa);


    }

}
