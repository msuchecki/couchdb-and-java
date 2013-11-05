package couchdb.sofa;


import java.util.List;
import org.ektorp.CouchDbConnector;
import org.ektorp.http.HttpClient;
import org.ektorp.impl.StdCouchDbConnector;
import org.ektorp.impl.StdCouchDbInstance;
import org.ektorp.spring.HttpClientFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: michal
 * Date: 10/14/13
 * Time: 9:44 PM
 */
@Configuration
@ComponentScan
public class Main {

    public static void main(String[] args) {
        new Main().couchMe();
    }

    @Bean(name = "sofadb")
    CouchDbConnector couchDbConnector() throws Exception {
        return new StdCouchDbConnector("sofa", new StdCouchDbInstance(couchHttpClient()));
    }

    public HttpClient couchHttpClient() throws Exception {

        HttpClientFactoryBean httpClientFactoryBean = new HttpClientFactoryBean();
        httpClientFactoryBean.setUrl("http://localhost:5984");
        httpClientFactoryBean.afterPropertiesSet();
        return httpClientFactoryBean.getObject();

    }

    private void couchMe() {

        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        SofaRepository sofaRepository = (SofaRepository) context.getBean("sofaRepository");

        List<Sofa> all = sofaRepository.getAll();

        all.forEach(s -> System.out.println(s));

    }
}
