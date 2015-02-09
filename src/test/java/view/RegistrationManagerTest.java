import org.jboss.arquillian.junit.Arquillian;
import view.RegistrationManager;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 *
 * @author Aeive
 */
@RunWith(Arquillian.class)
public class RegistrationManagerTest {
        
    RegistrationManager rm = new RegistrationManager();
    

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
        Assert.assertTrue(rm.test("930112-5176"));        
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
