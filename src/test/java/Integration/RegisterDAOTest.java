import controller.RejectException;
import integration.RegisterDAO;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import model.Person;
import model.Role;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RegisterDAOTest {
    
  
   
    private Person person;
    EntityManager mockedEm;
      
    @EJB
    RegisterDAO rdao = new RegisterDAO();
    
        
    @Before
    public void setUp(){
        mockedEm = mock(EntityManager.class);
        rdao.setEntityManager(mockedEm);        
        rdao.setTest(true);
    }
    
    @Rule
    public ExpectedException exception = ExpectedException.none();
      
    @Test
    public void registerTest() throws RejectException{
     
        exception.expect(NullPointerException.class);
        rdao.register("Test","Test","930112-5555", "email@test.com", "password ","Test");
        verify(mockedEm,times(1)).find(Role.class, "applicant");
        verify(mockedEm,times(1)).persist(any());
    }
    
    @Test
    public void findPersonTest(){
        rdao.findPerson("test");
        verify(mockedEm,times(1)).find(Person.class, "test");
    }
    
    @Test
    public void findRoleTest(){
        rdao.findRole("test");
        verify(mockedEm,times(1)).find(Role.class, "test");
    }
}