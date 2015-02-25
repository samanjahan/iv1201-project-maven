import controller.RejectException;
import integration.CompetenceDAO;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import model.Competence;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CompetenceDAOTest {
    
  
    EntityManager mockedEm;
      
    @EJB
    CompetenceDAO cdao = new CompetenceDAO();
    
        
    @Before
    public void setUp(){
        mockedEm = mock(EntityManager.class);
        cdao.setEntityManager(mockedEm);      
    }
    
    @Rule
    public ExpectedException exception = ExpectedException.none();
      
    @Test
    public void createCompetenceTest() throws RejectException{
     
        
        cdao.createCompetence("test","test");
        verify(mockedEm,times(2)).persist(any());
    }
    
    @Test
    public void getCompetenceTest(){
        cdao.getCompetence("test");
        verify(mockedEm,times(1)).find(Competence.class, "test");
    }
    
    @Test
    public void getAllCompetenceTest(){
        exception.expect(NullPointerException.class);
        cdao.getAllCompetence();
        verify(mockedEm,times(1)).createNamedQuery(anyString());
        
    }
      
    @Test
    public void deleteCompetenceTest() throws RejectException{
        exception.expect(NullPointerException.class);
        cdao.deleteCompetence(new Competence());
        verify(mockedEm,times(1)).createNamedQuery(anyString());        
        verify(mockedEm,times(2)).remove(any());
        
    }
    
}