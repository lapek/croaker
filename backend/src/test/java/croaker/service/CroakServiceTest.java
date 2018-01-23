package croaker.service;

import com.raven.croaker.CroakerApp;
import com.raven.croaker.domain.Croak;
import com.raven.croaker.service.CroakService;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CroakerApp.class)
public class CroakServiceTest {
    @Autowired
    private CroakService croakService;

    @Autowired
    private ElasticsearchTemplate esTemplate;

    @Before
    public void before() {
        esTemplate.deleteIndex(Croak.class); //TODO Mock tests /or/ do tests on a different cluser (to not delete data everytime)
        esTemplate.createIndex(Croak.class);
        esTemplate.putMapping(Croak.class);
        esTemplate.refresh(Croak.class);
    }

    @Test
    public void A_testSave() {
        Croak croak = new Croak();
        croak.setMessage("Test Message");
        croak.setUserId("12randomid34");
        croak.setUsername("testUsername 123");
        Croak testCroak = croakService.save(croak);

        assertNotNull(testCroak.getId());
        assertNotNull(testCroak.getPostDate());
        assertNotNull(testCroak.getLastEditDate());
        assertEquals(testCroak.getUsername(), croak.getUsername());
        assertEquals(testCroak.getUserId(), croak.getUserId());
        assertEquals(testCroak.getMessage(), croak.getMessage());
    }

//    @Test
//    public void B_testDelete() {
//        croakService.delete(croak);
//        Optional<Croak> testCroak = croakService.findOne(croak.getId());
//        assertFalse(testCroak.isPresent());
//    }
}
