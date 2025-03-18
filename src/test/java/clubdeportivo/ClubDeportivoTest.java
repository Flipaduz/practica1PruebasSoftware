package clubdeportivo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

public class ClubDeportivoTest {

    // Constructor:
    // No podemos crear club con la cantidad de grupos negativa DONE
    // No podemos crear club con la cantidad de grupos cero DONE
    // Si pasamos los datos correctos, se crea el club deportivo DONE
    //  

    @Test
    @DisplayName("No podemos crear club con la cantidad de grupos negativa")
    public void ClubDeportivo_CapacidadGruposNegativa_DevuelveExcepcion(){
        // Arrange
        String nombre = "CDTorremolinos";
        int ngrupos = -10;
        // Act & Assert 
        assertThrows(ClubException.class, ()->{
            new ClubDeportivo(nombre, ngrupos);
        });
    }
    
    @Test
    @DisplayName("No podemos crear club con la cantidad de grupos cero")
    public void ClubDeportivo_CapacidadGruposCero_DevuelveExcepcion(){
        // Arrange
        String nombre = "CDTorremolinos";
        int ngrupos = 0;
        // Act & Assert 
        assertThrows(ClubException.class, ()->{
            new ClubDeportivo(nombre, ngrupos);
        });
    }

    @Test
    @DisplayName("Si pasamos los datos correctos, se crea el club deportivo")
    public void ClubDeportivo_DatosCorrectos_CreaClub() throws ClubException{
        // Arrange
        String nombre = "CDTorremolinos";
        int ngrupos = 10;
        //Act & Assert 
        assertDoesNotThrow(()->{new ClubDeportivo(nombre, ngrupos);});
    }

    // Metodo #1: anyadirActividadConDatos
    // ------------------------
    //Al intentar crear un grupo con el arreglo nulo, devolvemos una excepción DONE
    //Al intentar crear un grupo con datos insuficientes, devolvemos una excepción DONE
    //Al pasar un array con datos excesivos no devuelve excepción DONE
    //Si intentamos añadir una actividad con el código nulo, devuelve excepción DONE
    //Si intentamos añadir una actividad con el nombre de actividad nulo, devuelve excepción DONE
    //Si intentamos añadir una actividad con el formato de plazas incorrecto, devuelve excepción DONE
    //Si intentamos añadir una actividad con plazas nulas, devuelve excepción DONE
    // Si intentamos añadir una actividad con el formato incorrecto de los matriculados, devuelve excepción DONE
    // Si intentamos añadir una actividad con el número de los matriculados nulo, devuelve excepción DONE
    // Si intentamos añadir una actividad con el formato de la tarifa incorrecto, devuelve excepción DONE
    // Si intentamos añadir una actividad con la tarifa nula, devuelve excepción DONE
    // Si los datos que se pasan son correctos, la actividad se añade. DONE


    @Test
    @DisplayName("Al intentar crear un grupo con el arreglo nulo, devolvemos una excepción")
    public void anyadirActividadDatos_ArrayNull_DevuelveExepcion() throws ClubException {
        //Arange
        String[] datos = null;
        String nombre = "CDTorremolinos";
        int ngrupos = 5;
        ClubDeportivo cd = new ClubDeportivo(nombre, ngrupos);
        //Act & Assert
        assertThrows(ClubException.class, () -> {
            cd.anyadirActividad(datos);
        });
    }

    @Test
    @DisplayName("Al intentar crear un grupo con datos insuficientes, devolvemos una excepción")
    public void anyadirActividadDatos_ArrayPocosElementos_DevuelveExepcion() throws ClubException {
        //Arange
        // Grupo con actividad:
        String codigo = "1";
        String actividad = "Natacion";
        String nplazas = "7";
        String[] datos = {codigo, actividad, nplazas};
        // Club:
        String nombre = "CDTorremolinos";
        int ngrupos = 5;
        ClubDeportivo cd = new ClubDeportivo(nombre, ngrupos);
        //Act & Assert
        assertThrows(ClubException.class, () -> {
            cd.anyadirActividad(datos);
        });
    }

    @Test
    @DisplayName("Al pasar un array con datos excesivos no devuelve excepción")
    public void anyadirActividadDatos_ArrayDemasiadosElementos_NoDevuelveExepcion() throws ClubException {
        // Arange:
        // Grupo con actividad
        String codigo = "1";
        String actividad = "Natacion";
        String nplazas = "7";
        String nmatriculados = "5";
        String tarifa = "12.0";
        String[] datos = {codigo, actividad, nplazas, nmatriculados, tarifa, "Exceso"};
        // Club donde se va a impartir la actividad
        String nombre = "CDTorremolinos";
        int ngrupos = 5;
        ClubDeportivo cd = new ClubDeportivo(nombre, ngrupos);
        // Act:
        cd.anyadirActividad(datos);
        //Assert:
        assertTrue(cd.toString().contains("("+ codigo + " - "+actividad+" - " + tarifa + " euros "+ "- P:" + nplazas +" - M:" +nmatriculados+")"));
    }

    @Test
    @DisplayName("Si intentamos añadir una actividad con el código nulo, devuelve excepción")
    public void anyadirActividadDatos_CodigoNulo_DevuelveExepcion() throws ClubException {
        //Arange
        String codigo = null;
        String actividad = "Natacion";
        String nplazas = "Incorrecto";
        String nmatriculados = "5";
        String tarifa = "12.0";
        String[] datos = {codigo, actividad, nplazas, nmatriculados, tarifa};
        String nombre = "CDTorremolinos";
        int ngrupos = 5;
        ClubDeportivo cd = new ClubDeportivo(nombre, ngrupos);
        //Act & Assert
        assertThrows(ClubException.class, () -> {
            cd.anyadirActividad(datos);
        });
    }
    @Test
    @DisplayName("Si intentamos añadir una actividad con el nombre de actividad nulo, devuelve excepción")
    public void anyadirActividadDatos_ActividadNula_DevuelveExepcion() throws ClubException {
        //Arange
        String codigo = "1";
        String actividad = null;
        String nplazas = "Incorrecto";
        String nmatriculados = "5";
        String tarifa = "12.0";
        String[] datos = {codigo, actividad, nplazas, nmatriculados, tarifa};
        String nombre = "CDTorremolinos";
        int ngrupos = 5;
        ClubDeportivo cd = new ClubDeportivo(nombre, ngrupos);
        //Act & Assert
        assertThrows(ClubException.class, () -> {
            cd.anyadirActividad(datos);
        });
    }
    
    
    @Test
    @DisplayName("Si intentamos añadir una actividad con el formato de plazas incorrecto, devuelve excepción")
    public void anyadirActividadDatos_nPlazasFormatoIncorrecto_DevuelveExepcion() throws ClubException {
        //Arange
        String codigo = "1";
        String actividad = "Natacion";
        String nplazas = "Incorrecto";
        String nmatriculados = "5";
        String tarifa = "12.0";
        String[] datos = {codigo, actividad, nplazas, nmatriculados, tarifa};
        
        String nombre = "CDTorremolinos";
        int ngrupos = 5;
        ClubDeportivo cd = new ClubDeportivo(nombre, ngrupos);
        //Act & Assert
        assertThrows(ClubException.class, () -> {
            cd.anyadirActividad(datos);
        });
    }
    
    @Test
    @DisplayName("Si intentamos añadir una actividad con plazas nulas, devuelve excepción")
    public void anyadirActividadDatos_nPlazasNulo_DevuelveExepcion() throws ClubException {
        //Arange
        String codigo = "1";
        String actividad = "Natacion";
        String nplazas = null;
        String nmatriculados = "5";
        String tarifa = "12.0";
        String[] datos = {codigo, actividad, nplazas, nmatriculados, tarifa};
        
        String nombre = "CDTorremolinos";
        int ngrupos = 5;
        ClubDeportivo cd = new ClubDeportivo(nombre, ngrupos);
        //Act & Assert
        assertThrows(ClubException.class, () -> {
            cd.anyadirActividad(datos);
        });
    }
    
    @Test
    @DisplayName("Si intentamos añadir una actividad con el formato incorrecto de los matriculados, devuelve excepción")
    public void anyadirActividadDatos_nMatriculadosFormatoIncorrecto_DevuelveExepcion() throws ClubException {
        //Arange
        String codigo = "1";
        String actividad = "Natacion";
        String nplazas = "7";
        String nmatriculados = "Incorrecto";
        String tarifa = "12.0";
        String[] datos = {codigo, actividad, nplazas, nmatriculados, tarifa};
        
        String nombre = "CDTorremolinos";
        int ngrupos = 5;
        ClubDeportivo cd = new ClubDeportivo(nombre, ngrupos);
        //Act & Assert
        assertThrows(ClubException.class, () -> {
            cd.anyadirActividad(datos);
        });
    }
    
    @Test
    @DisplayName("Si intentamos añadir una actividad con el número de los matriculados nulo, devuelve excepción")
    public void anyadirActividadDatos_nMatriculadosNulo_DevuelveExepcion() throws ClubException {
        //Arange
        String codigo = "1";
        String actividad = "Natacion";
        String nplazas = "7";
        String nmatriculados = null;
        String tarifa = "12.0";
        String[] datos = {codigo, actividad, nplazas, nmatriculados, tarifa};
        
        String nombre = "CDTorremolinos";
        int ngrupos = 5;
        ClubDeportivo cd = new ClubDeportivo(nombre, ngrupos);
        //Act & Assert
        assertThrows(ClubException.class, () -> {
            cd.anyadirActividad(datos);
        });
    }
    
    @Test
    @DisplayName("Si intentamos añadir una actividad con el formato de la tarifa incorrecto, devuelve excepción")
    public void anyadirActividadDatos_tarifaFormatoIncorrecto_DevuelveExepcion() throws ClubException {
        //Arange
        String codigo = "1";
        String actividad = "Natacion";
        String nplazas = "7";
        String nmatriculados = "5";
        String tarifa = "Incorrecto";
        String[] datos = {codigo, actividad, nplazas, nmatriculados, tarifa};
        
        String nombre = "CDTorremolinos";
        int ngrupos = 5;
        ClubDeportivo cd = new ClubDeportivo(nombre, ngrupos);
        //Act & Assert
        assertThrows(ClubException.class, () -> {
            cd.anyadirActividad(datos);
        });
    }
    
    @Test
    @DisplayName("Si intentamos añadir una actividad con la tarifa nula, devuelve excepción")
    public void anyadirActividadDatos_tarifaNula_DevuelveExepcion() throws ClubException {
        //Arange
        String codigo = "1";
        String actividad = "Natacion";
        String nplazas = "7";
        String nmatriculados = "5";
        String tarifa = null;
        String[] datos = {codigo, actividad, nplazas, nmatriculados, tarifa};
        
        String nombre = "CDTorremolinos";
        int ngrupos = 5;
        ClubDeportivo cd = new ClubDeportivo(nombre, ngrupos);
        //Act & Assert
        assertThrows(ClubException.class, () -> {
            cd.anyadirActividad(datos);
        });
    }
    
    @Test
    @DisplayName("Si los datos que se pasan son correctos, la actividad se añade.")
    public void anyadirActividadDatos_DatosCorrectos_AnyadimosActividad() throws ClubException {
        //Arange
        String codigo = "1";
        String actividad = "Natacion";
        String nplazas = "7";
        String nmatriculados = "5";
        String tarifa = "12.0";
        String[] datos = {codigo, actividad, nplazas, nmatriculados, tarifa};
        
        String nombre = "CDTorremolinos";
        int ngrupos = 5;
        ClubDeportivo cd = new ClubDeportivo(nombre, ngrupos);
        // Act
        cd.anyadirActividad(datos);
        //Assert
        assertTrue(cd.toString().contains("("+ codigo + " - "+actividad+" - " + tarifa + " euros "+ "- P:" + nplazas +" - M:" +nmatriculados+")"));
        
    }
    
    // Metodo #2: anyadirActividadConGrupo
    // -----------------------------------
    //Si añadimos actividad con el grupo nulo, se devuelve una excepción DONE
    //Si los datos que hemos pasado son correctos, el grupo se añade al club DONE
    //Si intentamos actualizar el número de plazas con un número menor que el número de las personas matriculadas, se actualiza con éxito DONE
    // Si intentamos añadir más grupos de los que podamos, se devuelve una excepción DONE
    // 
    
    
    @Test
    @DisplayName("Si añadimos actividad con el grupo nulo, se devuelve una excepción")
    public void anyadirActividadGrupo_GrupoEsNull_DevuelveExepcion() throws ClubException {
        //Arange
        Grupo g = null;
        String nombre = "CDTorremolinos";
        int ngrupos = 5;
        ClubDeportivo cd = new ClubDeportivo(nombre, ngrupos);
        //Act & Assert
        assertThrows(ClubException.class, () -> {
            cd.anyadirActividad(g);
        });
    }
   
    @Test
    @DisplayName("Si los datos que hemos pasado son correctos, el grupo se añade al club")
    public void anyadirActividadGrupo_GrupoNuevo_AnyadimosGrupo() throws ClubException {
        //Arange:
        // Grupo:
        String codigo = "1";
        String actividad = "Natacion";
        int nplazas = 7;
        int nmatriculados = 5;
        double tarifa = 12.0;
        Grupo g = new Grupo(codigo, actividad, nplazas, nmatriculados, tarifa);
        // Club:
        String nombre = "CDTorremolinos";
        int ngrupos = 5;
        ClubDeportivo cd = new ClubDeportivo(nombre, ngrupos);
        //Act:
        cd.anyadirActividad(g);
        //Assert:
        assertTrue(cd.toString().contains(g.toString()));

    }
    @Test
    @DisplayName("Si intentamos actualizar el número de plazas con un número menor que el número de las personas matriculadas, se actualiza con éxito")
    public void anyadirActividadGrupo_GrupoExistente_ActualizamosNplazas() throws ClubException {
        String codigo = "1";
        String actividad = "Natacion";
        int nplazas = 7;
        int nmatriculados = 5;
        double tarifa = 12.0;
        Grupo g1 = new Grupo(codigo, actividad, nplazas, nmatriculados, tarifa);
        int nuevoNPlazas = 10;
        Grupo g2 = new Grupo(codigo, actividad, nuevoNPlazas, nmatriculados, tarifa);

        String nombre = "CDTorremolinos";
        int ngrupos = 5;
        ClubDeportivo cd = new ClubDeportivo(nombre, ngrupos);
        cd.anyadirActividad(g1); // Añadimos grupo donde se imparte la actividad
        
        //Act
        cd.anyadirActividad(g2); // Añadimos otro grupo con la misma actividad
        int plazasActuales = cd.plazasLibres(actividad);

        //Assert
        assertEquals(nuevoNPlazas - nmatriculados, plazasActuales);
    }

    @Test
    @DisplayName("Si intentamos añadir más grupos de los que podamos, se devuelve una excepción")
    public void anyadirActividadGrupo_LimiteDeGruposSobrepasado_DevuelveExepcion() throws ClubException {
        //Arange
        String codigo = "1";
        String actividad1 = "Natacion";
        int nplazas = 7;
        int nmatriculados = 5;
        double tarifa = 12.0;
        Grupo g1 = new Grupo(codigo, actividad1, nplazas, nmatriculados, tarifa);

        String actividad2 = "Ajedrez";
        Grupo g2 = new Grupo(codigo, actividad2, nplazas, nmatriculados, tarifa);

        String nombre = "CDTorremolinos";
        int ngrupos = 1;
        ClubDeportivo cd = new ClubDeportivo(nombre, ngrupos);

        //Act
        cd.anyadirActividad(g1);

        //Act & Assert
        assertThrows(ClubException.class, () -> {
            cd.anyadirActividad(g2);
        });
    }


    // Metodo #3: plazasLibres
    // ------------------------

    //Si una actividad no existe, no tiene plazas libres DONE
    //Si una actividad no existe, no tiene plazas DONE
    //Si una actividad se imparte en más de un grupo, el total de plazas libres coincide con la suma de plazas libres de todos los grupos DONE
    // 
        
    @Test
    @DisplayName("Si una actividad no existe, no tiene plazas libres")
    public void plazasLibres_ActividadNoExiste_DevuelveCero() throws ClubException {
        // Arrange:
        // Nombre de actividad:
        String actividad = "Natacion";
        // Club:
        String nombre = "CDTorremolinos";
        int ngrupos = 5;
        ClubDeportivo cd = new ClubDeportivo(nombre, ngrupos);
        //Act:
        int result = cd.plazasLibres(actividad);
        //Assert:
        assertEquals(0, result);
    }
    
    @Test
    @DisplayName("Si una actividad no existe, no tiene plazas")
    public void plazasLibres_ActividadExiste_DevuelveCorrectamentePlazasLibres() throws ClubException {
        // Arrange:
        String codigo = "1";
        String actividad = "Natacion";
        int nplazas = 7;
        int nmatriculados = 5;
        double tarifa = 12.0;
        Grupo g = new Grupo(codigo, actividad, nplazas, nmatriculados, tarifa);
        int plazasLibreGrupo = g.plazasLibres();

        String nombre = "CDTorremolinos";
        ClubDeportivo cd = new ClubDeportivo(nombre);
        cd.anyadirActividad(g);
        //Act
        int result = cd.plazasLibres(actividad);
        //Assert
        assertEquals(plazasLibreGrupo, result);
    }
    
    @Test
    @DisplayName("Si una actividad se imparte en más de un grupo, el total de plazas libres coincide con la suma de plazas libres de todos los grupos")
    public void plazasLibres_ActividadSeImparteEnMasDeUnGrupo_DevuelveLasSumaDePlazasLibres() throws ClubException {
        String codigo = "1";
        String actividad = "Natacion";
        int nplazas = 7;
        int nmatriculados = 5;
        double tarifa = 12.0;
        Grupo g1 = new Grupo(codigo, actividad, nplazas, nmatriculados, tarifa);
        int plazasLibreGrupo1= g1.plazasLibres();

        codigo = "2";
        Grupo g2 = new Grupo(codigo, actividad, nplazas, nmatriculados, tarifa);
        int plazasLibreGrupo2= g2.plazasLibres();

        String nombre = "CDTorremolinos";
        int ngrupos = 5;

        ClubDeportivo cd = new ClubDeportivo(nombre, ngrupos);

        //Añadimos los grupos con la misma actividad
        cd.anyadirActividad(g1);
        cd.anyadirActividad(g2);

        //Act
        int resultado = cd.plazasLibres(actividad);

        //Assert
        assertEquals(plazasLibreGrupo1 + plazasLibreGrupo2, resultado);
    }

    // Metodo #4: ingresos
    // ------------------------
    // Si en un club no se imparte ninguna actividad, el ingreso es cero DONE
    // Si un club tiene grupos los ingresos deben ser coherentes DONE

    @Test
    @DisplayName("Si en un club no se imparte ninguna actividad, el ingreso es cero")
    public void ingresos_ClubDeportivoSinGrupos_DevuelveCero() throws ClubException {
        //Arrange
        String nombre = "CDTorremolinos";
        ClubDeportivo cd = new ClubDeportivo(nombre);
        //Act
        double result = cd.ingresos();
        //Assert
        assertEquals(0, result);
    }
    
    @Test
    @DisplayName("Si un club tiene grupos los ingresos deben ser coherentes")
    public void ingresos_ClubDeportivoConGrupos_DevuelveCorrectamenteIngresos() throws ClubException {
        // Arrange:
        String codigo = "1";
        String actividad1 = "Natacion";
        int nplazas = 7;
        int nmatriculados = 5;
        double tarifa1 = 12.0;
        Grupo g1 = new Grupo(codigo, actividad1, nplazas, nmatriculados, tarifa1);

        String actividad2 = "Ajedrez";
        double tarifa2 = 14.0;
        Grupo g2 = new Grupo(codigo, actividad2, nplazas, nmatriculados, tarifa2);
        double expectedIngresos = g1.getMatriculados()*g1.getTarifa() + g2.getMatriculados()*g2.getTarifa(); // Resultado esperado

        String nombre = "CDTorremolinos";
        ClubDeportivo cd = new ClubDeportivo(nombre);

        // Añadimos actividades:
        cd.anyadirActividad(g1);
        cd.anyadirActividad(g2);
        //Act:
        double actualIngresos = cd.ingresos();
        //Assert:
        assertEquals(expectedIngresos, actualIngresos);
    }

    // Metodo #5: matricular
    // ------------------------
    //Si el número de personas matriculadas supera plazas disponibles, devolvemos una excepción DONE
    //Si matriculamos 0 personas, no se producen cambios DONE
    //No podemos matricular a nadie en una actividad que no existe DONE
    //Si un grupo no tiene plazas suficiente para los matriculados, estos se reparten entre grupos donde se imparte la actividad DONE
    
    @Test
    @DisplayName("Si el número de personas matriculadas supera plazas disponibles, devolvemos una excepción")
    public void matricular_personasSuperanPlazas_DevuelveExepcion() throws ClubException {
        // Arrange
        String codigo = "1";
        String actividad = "Natacion";
        int nplazas = 10;
        int nmatriculados = 5;
        double tarifa = 12.0;
        Grupo g = new Grupo(codigo, actividad, nplazas, nmatriculados, tarifa);

        String nombre = "CDTorremolinos";
        int ngrupos = 5;
        ClubDeportivo cd = new ClubDeportivo(nombre, ngrupos);
        cd.anyadirActividad(g);
        int npersonas = 10;
        //Act & Assert
        assertThrows(ClubException.class, () -> {
            cd.matricular(actividad, npersonas);
        });
    }

    @Test
    @DisplayName("Si matriculamos 0 personas, no se producen cambios")
    public void matricular_CeroPersonas_NoHayCambios() throws ClubException {
        // Arrange:
        String codigo = "1";
        String actividad = "Natacion";
        int nplazas = 10;
        int nmatriculados = 5;
        double tarifa = 12.0;
        Grupo g = new Grupo(codigo, actividad, nplazas, nmatriculados, tarifa);
        String nombre = "CDTorremolinos";
        int ngrupos = 5;
        ClubDeportivo cd = new ClubDeportivo(nombre, ngrupos);
        cd.anyadirActividad(g);
        int npersonas = 0;
        int plazasLibresPrincipio = cd.plazasLibres(actividad);
        //Act
        cd.matricular(actividad, npersonas);
        //Assert
        // Al matricular cero personas, el número de plazas libre no varía,
        assertEquals(plazasLibresPrincipio, cd.plazasLibres(actividad));
    }


    @Test
    @DisplayName("No podemos matricular a nadie en una actividad que no existe")
    public void matricular_ActividadNoEstaEnClubDeportivo_DevuelveExepcion() throws ClubException {
        // Arrange:
        String actividad = "Ajedrez";
        String nombre = "CDTorremolinos";
        int ngrupos = 5;
        ClubDeportivo cd = new ClubDeportivo(nombre, ngrupos);
        int npersonas = 2;
        //Act & Assert
        assertThrows(ClubException.class, () -> {
            cd.matricular(actividad, npersonas);
        });
    }
    
    @Test
    @DisplayName("Si un grupo no tiene plazas suficiente para los matriculados, estos se reparten entre grupos donde se imparte la actividad")
    public void matricular_DiferentesGruposMismaActividad_SeMatriculanTodos() throws ClubException {
        // Arrange
        // Grupo 1:
        String codigo = "1";
        String actividad = "Natacion";
        int nplazas = 10;
        int nmatriculados = 5;
        double tarifa = 12.0;
        Grupo g1 = new Grupo(codigo, actividad, nplazas, nmatriculados, tarifa);
        // Grupo 2:
        String codigo2 = "2";
        Grupo g2 = new Grupo(codigo2, actividad, nplazas, nmatriculados, tarifa);
        // Club deportivo:
        String nombre = "CDTorremolinos";
        ClubDeportivo cd = new ClubDeportivo(nombre);
        cd.anyadirActividad(g1);
        cd.anyadirActividad(g2);
        int plazasIniciales = cd.plazasLibres(actividad);
        int npersonas = 6;
        //Act
        cd.matricular(actividad, npersonas);
        //Assert
        assertEquals(plazasIniciales- npersonas, cd.plazasLibres(actividad));
    }

}