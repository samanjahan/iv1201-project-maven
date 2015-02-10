import controller.PersonController;
import controller.RejectException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import model.Person;
import org.junit.Assert;
import org.junit.Test;



public class PersonControllerTest {
    
  
   
    private Person person;
    
    @EJB
    PersonController pc;
     
    @Test
    public void registerTest(){
        
        try {
            if((pc.findPerson("Test")) == null){
                pc.register("Test","Test","930112-5555", "email@test.com", "password ","Test");
            }
            person = pc.findPerson("Test");
            Assert.assertEquals("Test",person.getName());
            Assert.assertEquals("Test",person.getSurname());
            Assert.assertEquals("930112-5555",person.getSsn());
            Assert.assertEquals("email@test.com",person.getEmail());
            Assert.assertEquals("Test",person.getUsername());
            
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
}