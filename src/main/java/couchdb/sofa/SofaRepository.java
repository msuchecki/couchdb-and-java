package couchdb.sofa;

import org.ektorp.CouchDbConnector;
import org.ektorp.support.CouchDbRepositorySupport;
import org.ektorp.support.GenerateView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: michal
 * Date: 10/14/13
 * Time: 9:42 PM
 */
@Repository
public class SofaRepository extends CouchDbRepositorySupport<Sofa> {

    @Autowired
    protected SofaRepository(@Qualifier("sofadb") CouchDbConnector db) {
        super(Sofa.class, db);
    }

    @GenerateView
    public java.util.List<Sofa> findByTag() {
        return queryView("black");
    }
}
