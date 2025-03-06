package clubdeportivo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class ClubDeportivoAltoRendimientoTest {
    @Test
    @DisplayName("Si no se pasa suficientes datos devuelve una excepción")
    public void anyadirActividad_DatosInsuficientes_DevuelveExcepcion() throws ClubException{
        //Arrange:
        String datos[] = new String[4];
        datos[0] = "1"; // Código de actividad
        datos[1] = "natación"; // Nombre de actividad
        datos[2] = "5";   // Plazas
        datos[3] = "2"; // Matriculados

        ClubDeportivoAltoRendimiento clubAltoRendimiento = new ClubDeportivoAltoRendimiento("Complejo Deportivo", 120, 10);

        // Assert:        
        assertThrows(ClubException.class , () -> {
            clubAltoRendimiento.anyadirActividad(datos);
        });
    }
    @Test
    public void anyadirActividad_DemasiadoPlazas_SeAsignaValorMaximo() throws ClubException{
        //Arrange:
        String datos[] = new String[4];
        datos[0] = "1"; // Código de actividad
        datos[1] = "natación"; // Nombre de actividad
        datos[2] = "15";   // Plazas
        datos[3] = "12"; // Matriculados

        ClubDeportivoAltoRendimiento clubAltoRendimiento = new ClubDeportivoAltoRendimiento("Complejo Deportivo", 12, 10);
        
        // Act:
        clubAltoRendimiento.anyadirActividad(datos);

        //Assert:
        assertEquals(datos, clubAltoRendimiento);

    
    }
    
}
