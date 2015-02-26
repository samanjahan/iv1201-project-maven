import controller.PersonController;
import controller.RejectException;
import integration.RegisterDAO;
import javax.ejb.EJB;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class PersonControllerTest {
    
  
   
    RegisterDAO mockedRDAO;
      
    @EJB
    PersonController pc = new PersonController();
    
        
    @Before
    public void setUp(){
        mockedRDAO = mock(RegisterDAO.class);
        pc.setRegisterDAO(mockedRDAO);
    }
    
    @Test
    public void registerTest() throws RejectException{
        pc.register("Test","Test","930112-5555", "email@test.com", "password ","Test");
        verify(mockedRDAO,times(1)).register("Test","Test","930112-5555", "email@test.com", "password ","Test");
    }
    
    @Test
    public void usernameAvailableTest(){
        pc.usernameAvailable("Test");
        verify(mockedRDAO,times(1)).usernameAvailable("Test");        
    }
}