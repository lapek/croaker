package croaker.service;

import com.raven.croaker.CroakerApp;
import com.raven.croaker.domain.Croak;
import com.raven.croaker.service.CroakService;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CroakerApp.class)
public class CroakServiceTest {

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

    @Test
    public void testSave() {
        Croak croak = new Croak("1001",
                new DateTime(2015, 5, 27, 12, 0).toDate(),
                "Test Message");
        Croak testCroak = croakService.save(croak);

        assertNotNull(testCroak.getId());
        assertEquals(testCroak.getMessage(), croak.getMessage());
        assertEquals(testCroak.getPostDate(), croak.getPostDate());
    }

    @Test
    public void testDelete() {
        Croak creak = new Croak("1001",
                new DateTime(2015,05,27,0,0).toDate(),
                "Test Message");
        croakService.save(creak);
        croakService.delete(creak);
        Optional<Croak> testCroak = croakService.findOne(creak.getId());
        assertFalse(testCroak.isPresent());
    }
}
