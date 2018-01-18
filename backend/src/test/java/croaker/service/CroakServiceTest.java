package croaker.service;

import com.raven.croaker.CroakerApp;
import com.raven.croaker.domain.Croak;
import com.raven.croaker.service.CroakService;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.*;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = CroakerApp.class)
public class CroakServiceTest {

/*
    @Autowired
    private CroakService croakService;

    @Autowired
    private ElasticsearchTemplate esTemplate;

    @Before
    public void before() {
        esTemplate.deleteIndex(Croak.class);
        esTemplate.createIndex(Croak.class);
        esTemplate.putMapping(Croak.class);
        esTemplate.refresh(Croak.class);
    }
    */

//    @Test //TODO Fix Croak Service and that test too
//    public void testSave() {
//        Croak croak = new Croak();
//        croak.setMessage("Test Message");;
//        Croak testCroak = croakService.save(croak);
//
//        assertNotNull(testCroak.getId());
//        assertEquals(testCroak.getMessage(), croak.getMessage());
//    }

//    @Test
//    public void testDelete() {
//        Date date = new DateTime(2015, 5, 27, 12, 0).toDate();
//        Croak croak = new Croak(date, date, "Test Message");
//        croakService.save(croak);
//        croakService.delete(croak);
//        Optional<Croak> testCroak = croakService.findOne(croak.getId());
//        assertFalse(testCroak.isPresent());
//    }
}
