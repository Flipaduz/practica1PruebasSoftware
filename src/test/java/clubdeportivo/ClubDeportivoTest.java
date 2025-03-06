package clubdeportivo;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ClubDeportivoTest {
    
    @Test
    public void ValoresValidosAlanyadirActividad() throws ClubException{
        //Arrange
        ClubDeportivo cd = new ClubDeportivo("Malaga");
        //String[] datos ={"str1","str2","10","20","1.34"};
        String[] datos ={"str1","str2","str3","str4","str5"};
        //Act
        assertThrows(ClubException.class,() ->{cd.anyadirActividad(datos);});

        //Assert
        //assertEquals(exception, "ERROR: formato de número incorrecto");
    }

}
