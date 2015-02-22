/*import controller.PersonController;
import controller.RejectException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import model.Person;
import model.Role;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class PersonControllerTest {
    
  
   
    private Person person;
    EntityManager mockedEm;
    EntityManager mockedRoleEm;
      
    @EJB
    PersonController pc = new PersonController();
    
        
    @Before
    public void setUp(){
        mockedEm = mock(EntityManager.class);
        mockedRoleEm = mock(EntityManager.class);
        pc.setEntityManager(mockedEm);
      //  pc.setRoleEntityManager(mockedRoleEm);
    }
    
    @Test
    public void registerTest(){
        
        try {
            if((pc.findPerson("Test")) == null){
                pc.register("Test","Test","930112-5555", "email@test.com", "password ","Test");
            }
            
            verify(mockedRoleEm,times(1)).find(Role.class, "admin");
            verify(mockedEm,times(1)).persist(any());
        } catch (RejectException ex) {
            Logger.getLogger(PersonControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
    
    
    public void usernameAvailableTest(){
        try {
            if((person = pc.findPerson("Test")) ==null){
                pc.register("Test","Test","930112-5555", "email@test.com", "password ","Test");
                person = pc.findPerson("Test");
            }
            Assert.assertFalse(pc.usernameAvailable("Test"));
           
        } catch (RejectException ex) {
            Logger.getLogger(PersonControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}*/