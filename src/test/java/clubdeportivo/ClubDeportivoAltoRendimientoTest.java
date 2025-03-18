package clubdeportivo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class ClubDeportivoAltoRendimientoTest {
     //Constructor:
     // No podemos crear club de alto rendimiento si el número de plazas máximas es cero DONE
     // No podemos crear club de alto rendimiento si el número de plazas máximas es negativo DONE 
     // No podemos crear club de alto rendimiento con el incremento cero DONE 
     // No podemos crear club de alto rendimiento con el incremento negativo DONE 
     // Si los datos son correctos, el club se crea con éxito, es decir, no se lanza ninguna excepción <-

    @Test
    @DisplayName("No podemos crear club de alto rendimiento si el número de plazas máximas es cero en el Constructor1")
    public void ClubDeportivoAltoRendimiento_MaximoCeroConstructor1_DevuelveExcepcion(){
        // Arrange:
        String nombre = "Atlético";
        int max = 0;
        double inc = 10;
        // Act & Assert:
        assertThrows(ClubException.class, ()->{
            new ClubDeportivoAltoRendimiento(nombre, max, inc);
        });
    }

    @Test
    @DisplayName("No podemos crear club de alto rendimiento si el número de plazas máximas es cero en el Constructor2")
    public void ClubDeportivoAltoRendimiento_MaximoCeroConstructor2_DevuelveExcepcion(){
        // Arrange:
        String nombre = "Atlético";
        int max = 0;
        double inc = 10;
        // Act & Assert:
        assertThrows(ClubException.class, ()->{
            new ClubDeportivoAltoRendimiento(nombre, 2, max, inc);
        });
    }

    @Test
    @DisplayName("No podemos crear club de alto rendimiento si el número de plazas máximas es negativo en Constructor1")
    public void ClubDeportivoAltoRendimiento_MaximoNegativoConstructor1_DevuelveExcepcion(){
        // Arrange:
        String nombre = "Atlético";
        int max = -1;
        double inc = 10;
        // Assert:
        // Comprobamos los dos constructores: En el primer caso no tiene grupos, en el segundo se crea con dos grupos
        assertThrows(ClubException.class, ()->{
            new ClubDeportivoAltoRendimiento(nombre, max, inc);
         });
    }

    @Test
    @DisplayName("No podemos crear club de alto rendimiento si el número de plazas máximas es negativo en Constructor2")
    public void ClubDeportivoAltoRendimiento_MaximoNegativoConstructor2_DevuelveExcepcion(){
        // Arrange:
        String nombre = "Atlético";
        int max = -1;
        double inc = 10;
        // Act & Assert:
        assertThrows(ClubException.class, ()->{
            new ClubDeportivoAltoRendimiento(nombre, 2, max, inc);
        });
    }
    
    @Test
    @DisplayName("No podemos crear club de alto rendimiento con el incremento cero en Constructor1")
    public void ClubDeportivoAltoRendimiento_IncrementoNuloConstructor1_DevuelveExcepción(){
        // Arrange:
        String nombre = "Atlético";
        int max = 10;
        double inc = 0;
        // Assert:
        // Comprobamos los dos constructores: En el primer caso no tiene grupos, en el segundo se crea con dos grupos
        assertThrows(ClubException.class, ()->{
             new ClubDeportivoAltoRendimiento(nombre, max, inc);
         });
    }

    @Test
    @DisplayName("No podemos crear club de alto rendimiento con el incremento cero o en Constructor2")
    public void ClubDeportivoAltoRendimiento_IncrementoNuloConstructor2_DevuelveExcepción(){
        // Arrange:
        String nombre = "Atlético";
        int max = 10;
        double inc = 0;
        // Act & Assert:
        assertThrows(ClubException.class, ()->{
            new ClubDeportivoAltoRendimiento(nombre, 2, max, inc);
        });
    }

    @Test
    @DisplayName("No podemos crear club de alto rendimiento con el incremento negativo en Constructor1")
    public void ClubDeportivoAltoRendimiento_IncrementoNegativoConstructor1_DevuelveExcepcion(){
        // Arrange:
        String nombre = "Atlético";
        int max = 10;
        double inc = -1;
        // Act & Assert:
        assertThrows(ClubException.class, ()->{
            new ClubDeportivoAltoRendimiento(nombre, max, inc);
         });
    }

    @Test
    @DisplayName("No podemos crear club de alto rendimiento con el incremento negativo en Constructor2")
    public void ClubDeportivoAltoRendimiento_IncrementoNegativoConstructor2_DevuelveExcepcion(){
        // Arrange:
        String nombre = "Atlético";
        int max = 10;
        double inc = -1;
        // Act & Assert:
        assertThrows(ClubException.class, ()->{
            new ClubDeportivoAltoRendimiento(nombre, 2, max, inc);
        });
    }
    
    @Test
    @DisplayName("Si los datos son correctos, el club se crea con éxito, es decir, no se lanza ninguna excepción en Constructor1")
    public void ClubDeportivoAltoRendimiento_DatosCorrectosConstructor1_SeCreaElClub(){
        // Arrange:
        String nombre = "Atlético";
        int max = 10;
        double inc = 5;
        //Act & Assert:
        assertDoesNotThrow(()->{
             new ClubDeportivoAltoRendimiento(nombre, max, inc);
         });
    }

    @Test
    @DisplayName("Si los datos son correctos, el club se crea con éxito, es decir, no se lanza ninguna excepción en Constructor2")
    public void ClubDeportivoAltoRendimiento_DatosCorrectosConstructor2_SeCreaElClub(){
        // Arrange:
        String nombre = "Atlético";
        int max = 10;
        double inc = 5;
        //Act & Assert:
        assertDoesNotThrow(()->{
            new ClubDeportivoAltoRendimiento(nombre,2, max, inc);
        });
    }
    
    // Metodo #2: anyadirActividadConDatos
    // -----------------------------------
    // Si el array de datos es nulo, devolvemos una excepcion DONE
    // Si no se pasa suficientes datos devuelve una excepción DONE
    // Si se intenta añadir una actividad con el número de plazas mayor que el permitido, se establece el valor máximo DONE
    // Si se intenta añadir una actividad con el formato de plazas incorrecto, devuelve una excepción DONE
    // Si se intentar matricular a las personas con el formato negativo, se lanza una excepción DONE
    // Si se intenta añadir una actividad con el formato de tarifa incorrecto, devuelve una excepción DONE
    // Si en un club no se imparte ninguna actividad, el ingreso es nulo DONE
    // Los ingresos del club deben ser coherentes con el incremento DONE
    // Los ingresos del club deben ser coherentes con el incremento DONE

    @Test
    @DisplayName("Si el array de datos es nulo, devolvemos una excepcion")
    public void anyadirActividad_DatosNulos_DevuelveExcepcion() throws ClubException{
        //Arrange:
        String datos[] = null;
        ClubDeportivoAltoRendimiento clubAltoRendimiento = new ClubDeportivoAltoRendimiento("Complejo Deportivo", 120, 10);
        //Act & Assert:
        assertThrows(ClubException.class , () -> {
            clubAltoRendimiento.anyadirActividad(datos);
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
        //Act & Assert:
        assertThrows(ClubException.class, ()->{
            clubAltoRendimiento.anyadirActividad(datos);
        });    
    }
    @Test
    @DisplayName("Si al intentar matricular a las personas con el formato negativo, se lanza una excepción")
    public void anyadirActividad_FormatoMatriculadosIncorrecto_DevuelveExcepcion() throws ClubException{
        //Arrange:
        String datos[] = new String[5];
        datos[0] = "1"; // Código de actividad
        datos[1] = "natación"; // Nombre de actividad
        datos[2] = "15";   // Plazas
        datos[3] = "cero"; // Matriculados
        datos[4] = "3";   //Tarifa
        ClubDeportivoAltoRendimiento clubAltoRendimiento = new ClubDeportivoAltoRendimiento("Complejo Deportivo", 12, 10);        
        //Act & Assert:
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
        //Act & Assert:
        assertThrows(ClubException.class, ()->{
            clubAltoRendimiento.anyadirActividad(datos);
        });  
    }
    @Test
    @DisplayName("Si en un club no se imparte ninguna actividad, el ingreso es nulo")
    public void ingresos_NoHayActividades_DevuelveCero() throws ClubException{
        // Arrange:
        ClubDeportivoAltoRendimiento clubAltoRendimiento = new ClubDeportivoAltoRendimiento("Complejo Deportivo", 12, 10);  
        // Act:
        double ingresos = clubAltoRendimiento.ingresos();
        // Assert:
        assertEquals(0, ingresos);      
    }
    @Test
    @DisplayName("Los ingresos del club deben ser coherentes con el incremento")
    public void ingresos_UnaActividad_DevuelvenLosIngresosCorrectos() throws ClubException{
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
    @Test
    @DisplayName("Los ingresos del club deben ser coherentes con el incremento")
    public void ingresos_DosActividades_DevuelvenLosIngresos() throws ClubException{
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
        // Añadimos otra actividad al club de alto rendimiento:
        datos[0] = "2"; // Código de actividad
        datos[1] = "Powerlifting"; // Nombre de actividad
        datos[2] = "10";   // Plazas
        datos[3] = "5"; // Matriculados
        datos[4] = "2"; // Tarifa    
        clubAltoRendimiento.anyadirActividad(datos);
        // Calculamos el valor esperado :
        double excpected = (10*3 + (10*3)*10/100) + (5*2 + (5*2)*10/100);        
        //Act:
        double ingresos = clubAltoRendimiento.ingresos();
        // Assert:
        assertEquals(excpected, ingresos);
    }
}
