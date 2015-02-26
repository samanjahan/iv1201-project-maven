package controller;

import controller.AdminController;
import controller.RejectException;
import integration.CompetenceDAO;
import javax.ejb.EJB;
import model.Competence;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class AdminControllerTest {
    
  
   
    CompetenceDAO mockedCDAO;
      
    @EJB
    AdminController ac = new AdminController();
    
        
    @Before
    public void setUp(){
        mockedCDAO = mock(CompetenceDAO.class);
        ac.setCompetenceDAO(mockedCDAO);
    }
    
    @Test
    public void createCompetenceTest() throws RejectException{
        ac.createCompetence("test", "test1");
        verify(mockedCDAO,times(1)).createCompetence("test", "test1");
    }
    
    @Test
    public void competenceAvailableTest() throws RejectException{
        ac.competenceAvailable("test");
        verify(mockedCDAO,times(1)).getCompetence("test");
    }
        
    @Test
    public void getAllAcompetenceTest() throws RejectException{
        ac.getAllAcompetence();
        verify(mockedCDAO,times(1)).getAllCompetence();
    }    
    
    @Test
    public void deleteCompetenceTest() throws RejectException{
        Competence test = new Competence();
        ac.deleteCompetence(test);
        verify(mockedCDAO,times(1)).deleteCompetence(test);
    }
  
}