import controller.PersonController;
import controller.RejectException;
import view.RegistrationManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;


/**
 *
 * @author Aeive
 */
@RunWith(MockitoJUnitRunner.class)
public class RegistrationManagerTest {
        
    RegistrationManager rm = new RegistrationManager();
    PersonController mockedPC;
    
    @Before
    public void setUp(){
        mockedPC = mock(PersonController.class);
        when(mockedPC.usernameAvailable("test")).thenReturn(true);
        rm.setPersonController(mockedPC);
    }

    @Test
    public void registerTest() throws RejectException{
        rm.setTest(true);
        rm.setName("test");
        rm.setSurname("test");
        rm.setSsn("000000-0000");
        rm.setEmail("test@test.test");
        rm.setUsername("test");
        rm.setPassword("test");
        rm.setMessage("test");
        rm.register();
        verify(mockedPC,times(1)).register("test","test","000000-0000","test@test.test","test","test");
    }
    @Test
    public void nameValidationTest(){
        Assert.assertFalse(rm.nameValidation(""));
        Assert.assertFalse(rm.nameValidation("arash safari"));
        Assert.assertFalse(rm.nameValidation("arash1"));
        Assert.assertFalse(rm.nameValidation("123"));
        Assert.assertFalse(rm.nameValidation("A-rash"));
        Assert.assertTrue(rm.nameValidation("arash"));
        Assert.assertTrue(rm.nameValidation("Arash"));
        Assert.assertTrue(rm.nameValidation("göran"));
        Assert.assertTrue(rm.nameValidation("Göran"));
        Assert.assertTrue(rm.nameValidation("A")); 
    }
    
    @Test
    public void ssnValidationTest(){
        Assert.assertFalse(rm.ssnValidation(""));
        Assert.assertFalse(rm.ssnValidation("ssnnummer"));
        Assert.assertFalse(rm.ssnValidation("123"));
        Assert.assertFalse(rm.ssnValidation("19930112-1234"));
        Assert.assertFalse(rm.ssnValidation("9301121234"));
        Assert.assertFalse(rm.ssnValidation("930112_1234"));
        Assert.assertTrue(rm.ssnValidation("930112-5176"));        
    }
    
    @Test
    public void emailValidationTest(){
        Assert.assertFalse(rm.emailValidation(""));     
        Assert.assertFalse(rm.emailValidation("email"));     
        Assert.assertFalse(rm.emailValidation("@mail.com"));         
        Assert.assertFalse(rm.emailValidation("e*&%#@hotmail.com"));    
        Assert.assertFalse(rm.emailValidation("email@hot-mail.com"));    
        Assert.assertTrue(rm.emailValidation("email@hotmail.com"));     
        Assert.assertTrue(rm.emailValidation("e-mail@hotmail.com"));       
        Assert.assertTrue(rm.emailValidation("e_mail@hotmail.com"));     
        Assert.assertTrue(rm.emailValidation("-._@hotmail.com"));    
    }
    
}
