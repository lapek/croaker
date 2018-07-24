package croaker.service;

import com.raven.croaker.CroakerApp;
import com.raven.croaker.domain.Croak;
import com.raven.croaker.domain.CroakRepository;
import com.raven.croaker.service.internal.CroakServiceImpl;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CroakerApp.class)
public class CroakServiceImplTest {
    private CroakServiceImpl croakServiceImpl;
    @Mock
    private CroakRepository croakRepository;
    @Mock
    private Croak croak;
    @Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
        croakServiceImpl=new CroakServiceImpl();
        croakServiceImpl.setCroakRepository(croakRepository);
    }

}
