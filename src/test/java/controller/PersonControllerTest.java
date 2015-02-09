
import controller.PersonController;
import controller.RejectException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import model.Person;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(Arquillian.class)
public class PersonControllerTest {
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class,"test.jar")
            .addClasses(Person.class, PersonController.class);
    }
    
   
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