package clubdeportivo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class ClubDeportivoAltoRendimientoTest {

    @Test
    @DisplayName("No podemos crear un club con el máximo número de plazas nulo")
    public void ClubDeportivoAltoRendimiento_MaximoNulo_DevuelveExcepción(){
        // Arrange:
        String nombre = "Atlético";
        int max = 0;
        double inc = 10;

        // Assert:
        // Comprobamos los dos constructores: En el primer caso no tiene grupos, en el segundo se crea con dos grupos
        assertThrows(ClubException.class, ()->{
           ClubDeportivoAltoRendimiento club=  new ClubDeportivoAltoRendimiento(nombre, max, inc);
        });
        assertThrows(ClubException.class, ()->{
            ClubDeportivoAltoRendimiento club=  new ClubDeportivoAltoRendimiento(nombre, 2, max, inc);
         });

    }
    @Test
    @DisplayName("No podemos crear un club con el máximo número de plazas es negativo")
    public void ClubDeportivoAltoRendimiento_MaximoNegativo_DevuelveExcepción(){
        // Arrange:
        String nombre = "Atlético";
        int max = -1;
        double inc = 10;

        // Assert:
        // Comprobamos los dos constructores: En el primer caso no tiene grupos, en el segundo se crea con dos grupos
        assertThrows(ClubException.class, ()->{
            ClubDeportivoAltoRendimiento club=  new ClubDeportivoAltoRendimiento(nombre, max, inc);
         });
         assertThrows(ClubException.class, ()->{
             ClubDeportivoAltoRendimiento club=  new ClubDeportivoAltoRendimiento(nombre, 2, max, inc);
          });

    }
    @Test
    @DisplayName("No podemos crear un club con el incremento nulo")
    public void ClubDeportivoAltoRendimiento_IncrementoNulo_DevuelveExcepción(){
        // Arrange:
        String nombre = "Atlético";
        int max = 10;
        double inc = 0;

        // Assert:
        // Comprobamos los dos constructores: En el primer caso no tiene grupos, en el segundo se crea con dos grupos
        assertThrows(ClubException.class, ()->{
            ClubDeportivoAltoRendimiento club=  new ClubDeportivoAltoRendimiento(nombre, max, inc);
         });
         assertThrows(ClubException.class, ()->{
             ClubDeportivoAltoRendimiento club=  new ClubDeportivoAltoRendimiento(nombre, 2, max, inc);
          });

    }
    @Test
    @DisplayName("No podemos crear un club con el incremento negativo")
    public void ClubDeportivoAltoRendimiento_IncrementoNegativo_DevuelveExcepción(){
        // Arrange:
        String nombre = "Atlético";
        int max = 10;
        double inc = -1;

        // Assert:
        // Comprobamos los dos constructores: En el primer caso no tiene grupos, en el segundo se crea con dos grupos
        assertThrows(ClubException.class, ()->{
            ClubDeportivoAltoRendimiento club=  new ClubDeportivoAltoRendimiento(nombre, max, inc);
         });
         assertThrows(ClubException.class, ()->{
             ClubDeportivoAltoRendimiento club=  new ClubDeportivoAltoRendimiento(nombre, 2, max, inc);
          });

    }
    @Test
    @DisplayName("Si no se pasa suficientes datos devuelve una excepción")
    public void anyadirActividad_DatosInsuficientes_DevuelveExcepcion() throws ClubException{
        //Arrange:
        String datos[] = new String[4];
        datos[0] = "1"; // Código de actividad
        datos[1] = "natación"; // Nombre de actividad
        ClubDeportivoAltoRendimiento clubAltoRendimiento = new ClubDeportivoAltoRendimiento("Complejo Deportivo", 120, 10);

        // Assert:
        // Comprobamos los dos constructores: En el primer caso no tiene grupos, en el segundo se crea con dos grupos     
        assertThrows(ClubException.class , () -> {
            clubAltoRendimiento.anyadirActividad(datos);
        });
    }
   
    @Test
    @DisplayName("Si se intenta añadir una actividad con el número de plazas mayor que el permitido, se establece el valor máximo")
    public void anyadirActividad_DemasiadoPlazas_SeAsignaValorMaximo() throws ClubException{
        //Arrange:
        String datos[] = new String[5];
        datos[0] = "1"; // Código de actividad
        datos[1] = "natación"; // Nombre de actividad
        datos[2] = "15";   // Plazas
        datos[3] = "0"; // Matriculados
        datos[4] = "3.0"; // Tarifa
        ClubDeportivoAltoRendimiento clubAltoRendimiento = new ClubDeportivoAltoRendimiento("Complejo Deportivo", 12, 10);        
        // Act:
        clubAltoRendimiento.anyadirActividad(datos);
        //Assert:
        // Comprobamos que el grupo se ha añadido y que la cantidad de plazas corresponde a la capacidad máxima
        assertTrue(clubAltoRendimiento.toString().contains(("("+ datos[0] + " - "+datos[1]+" - " + datos[4] + " euros "+ "- P:" + 12 +" - M:" +datos[3]+")")));
    }
    @Test
    @DisplayName("Si se intenta añadir una actividad con el formato de plazas incorrecto, devuelve una excepción")
    public void anyadirActividad_FormatoPlazasIncorrecto_DevuelveExcepcion() throws ClubException{
        //Arrange:
        String datos[] = new String[5];
        datos[0] = "1"; // Código de actividad
        datos[1] = "natación"; // Nombre de actividad
        datos[2] = "quince";   // Plazas
        datos[3] = "0"; // Matriculados
        datos[4] = "3"; //Tarifa
        ClubDeportivoAltoRendimiento clubAltoRendimiento = new ClubDeportivoAltoRendimiento("Complejo Deportivo", 2, 12,10);        
        // Assert & Act:
        assertThrows(ClubException.class, ()->{
            clubAltoRendimiento.anyadirActividad(datos);
        });    
    }
    @Test
    @DisplayName("Si se intenta añadir una actividad con el formato de plazas incorrecto, devuelve una excepción")
    public void anyadirActividad_FormatoMatriculadosIncorrecto_DevuelveExcepcion() throws ClubException{
        //Arrange:
        String datos[] = new String[5];
        datos[0] = "1"; // Código de actividad
        datos[1] = "natación"; // Nombre de actividad
        datos[2] = "15";   // Plazas
        datos[3] = "cero"; // Matriculados
        datos[4] = "3";   //Tarifa
        ClubDeportivoAltoRendimiento clubAltoRendimiento = new ClubDeportivoAltoRendimiento("Complejo Deportivo", 12, 10);        
        // Assert & Act:
        assertThrows(ClubException.class, ()->{
            clubAltoRendimiento.anyadirActividad(datos);
        });  
    }
    @Test
    @DisplayName("Si se intenta añadir una actividad con el formato de tarifa incorrecto, devuelve una excepción")
    public void anyadirActividad_FormatoTarifaIncorrecto_DevuelveExcepcion() throws ClubException{
        //Arrange:
        String datos[] = new String[5];
        datos[0] = "1"; // Código de actividad
        datos[1] = "natación"; // Nombre de actividad
        datos[2] = "15";   // Plazas
        datos[3] = "0"; // Matriculados
        datos[4] = "tres"; //Tarifa
        ClubDeportivoAltoRendimiento clubAltoRendimiento = new ClubDeportivoAltoRendimiento("Complejo Deportivo", 12, 10);        
        // Assert & Act:
        assertThrows(ClubException.class, ()->{
            clubAltoRendimiento.anyadirActividad(datos);
        });  
    }
    @Test
    @DisplayName("Los ingresos del club deben ser coherentes con el incremento")
    public void ingresos_FormatoTarifaIncorrecto_DevuelveExcepcion() throws ClubException{
        //Arrange:
        String datos[] = new String[5];
        datos[0] = "1"; // Código de actividad
        datos[1] = "natación"; // Nombre de actividad
        datos[2] = "12";   // Plazas
        datos[3] = "10"; // Matriculados
        datos[4] = "3"; // Tarifa
        ClubDeportivoAltoRendimiento clubAltoRendimiento = new ClubDeportivoAltoRendimiento("Complejo Deportivo", 12, 10);
        // Añadimos una actividad al club de alto rendimiento:
        clubAltoRendimiento.anyadirActividad(datos);
        // Calculamos el valor esperado :
        double excpected = 10*3 + (10*3)*10/100;        
        //Act:
        double ingresos = clubAltoRendimiento.ingresos();
        // Assert:
        assertEquals(excpected, ingresos);
    }
    
}
