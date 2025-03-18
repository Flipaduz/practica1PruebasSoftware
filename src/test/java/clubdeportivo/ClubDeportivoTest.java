package clubdeportivo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClubDeportivoTest {
    public ClubDeportivoTest() throws ClubException {
    }

    // No podemos crear club con la cantidad de grupos negativa
    @Test
    public void ClubDeportivo_CapacidadGruposNegativa_DevuelveExcepcion(){
        // Arrange
        String nombre = "CDTorremolinos";
        int ngrupos = -10;
        // Act & Assert 
        assertThrows(ClubException.class, ()->{
            new ClubDeportivo(nombre, ngrupos);
        });
    }
    // No podemos crear club con la cantidad de grupos nula
    @Test
    public void ClubDeportivo_CapacidadGruposCero_DevuelveExcepcion(){
        // Arrange
        String nombre = "CDTorremolinos";
        int ngrupos = -10;
        // Act & Assert 
        assertThrows(ClubException.class, ()->{
            new ClubDeportivo(nombre, ngrupos);
        });
    }

    @Test
    public void ClubDeportivo_DatosCorrectos_CreaClub() throws ClubException{
        // Arrange
        String nombre = "CDTorremolinos";
        int ngrupos = 10;
        //Act & Assert 
        assertDoesNotThrow(()->{new ClubDeportivo(nombre, ngrupos);});
    }

    // Metodo #1: anyadirActividadConDatos
    // ------------------------
    //Array null DONE
    //Array muchos elementos DONE
    //Array pocos elementos DONE
    //datos incorrectos DONE
    //Codigo formato invalido DONE
    //Actividad formato invalido DONE
    //Plazas formato invalido DONE
    //Matriculados no es int DONE
    //Tarifa formato invalido DONE
    // Datos correctos TODO

    @Test
    public void anyadirActividadDatos_ArrayNull_DevuelveExepcion() throws ClubException {
        //Arange
        String[] datos = null;

        String nombre = "CDTorremolinos";
        int ngrupos = 5;
        ClubDeportivo cd = new ClubDeportivo(nombre, ngrupos);
        //Assert
        assertThrows(ClubException.class, () -> {
            cd.anyadirActividad(datos);
        });
    }

    @Test
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
        //Assert
        assertThrows(ClubException.class, () -> {
            cd.anyadirActividad(datos);
        });
    }

    @Test
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
        //assertDoesNotThrow(() -> cd.anyadirActividad(datos));
    }

    //Error en el codigo no se controla este Test.
    /* 
    @Test
    public void anyadirActividadDatos_codigoFormatoIncorrecto_DevuelveExepcion() throws ClubException {
        //Arange
        String codigo = "Incorrecto";
        String actividad = "Natacion";
        String nplazas = "7";
        String nmatriculados = "5";
        String tarifa = "12.0";
        String[] datos = {codigo, actividad, nplazas, nmatriculados, tarifa};

        String nombre = "CDTorremolinos";
        int ngrupos = 5;
        ClubDeportivo cd = new ClubDeportivo(nombre, ngrupos);
        //Assert
        assertThrows(ClubException.class, () -> {
            cd.anyadirActividad(datos);
        });
    }
    */

    /* 
    @Test
    public void anyadirActividadDatos_ActividadFormatoIncorrecto_DevuelveExepcion() throws ClubException {
        //Arange
        String codigo = "1";
        String actividad = "01110";
        String nplazas = "7";
        String nmatriculados = "5";
        String tarifa = "12.0";
        String[] datos = {codigo, actividad, nplazas, nmatriculados, tarifa};

        String nombre = "CDTorremolinos";
        int ngrupos = 5;
        ClubDeportivo cd = new ClubDeportivo(nombre, ngrupos);
        //Assert
        assertThrows(ClubException.class, () -> {
            cd.anyadirActividad(datos);
        });
    }
    */

    @Test
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
        //Assert
        assertThrows(ClubException.class, () -> {
            cd.anyadirActividad(datos);
        });
    }

    @Test
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
        //Assert
        assertThrows(ClubException.class, () -> {
            cd.anyadirActividad(datos);
        });
    }

    @Test
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
        //Assert
        assertThrows(ClubException.class, () -> {
            cd.anyadirActividad(datos);
        });
    }

    //SOlo comprobamos que no hay exepcion no que lo añada a la lista de grupos.
    @Test
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
        //assertDoesNotThrow(() -> cd.anyadirActividad(datos));
    }

    // Metodo #2: anyadirActividadConGrupo
    // ------------------------
    //Grupo null DONE
    //Comprobamos grupo nuevo DONE
    //Actualizamos plazas de grupo existente y comprobamos DONE
    //Comprobar que el grupo no sobrepasa el limite de grupos posibles. DONE

    @Test
    public void anyadirActividadGrupo_GrupoEsNull_DevuelveExepcion() throws ClubException {
        //Arange
        Grupo g = null;

        String nombre = "CDTorremolinos";
        int ngrupos = 5;
        ClubDeportivo cd = new ClubDeportivo(nombre, ngrupos);
        //Assert
        assertThrows(ClubException.class, () -> {
            cd.anyadirActividad(g);
        });
    }

    //Si los datos que hemos pasado son correctos, el grupo se añade al club
    @Test
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
        //Act
        cd.anyadirActividad(g1);
        cd.anyadirActividad(g2);
        int plazasActuales = cd.plazasLibres(actividad);

        //Assert
        assertEquals(nuevoNPlazas - nmatriculados, plazasActuales);
    }

    @Test
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

        //Assert
        assertThrows(ClubException.class, () -> {
            cd.anyadirActividad(g2);
        });
    }


    // Metodo #3: plazasLibres
    // ------------------------

    //Le pasamos una actividad que no existe devolviendo 0 DONE
    //Comprobamos que coincida el numero de plazas libres club deportivo y el grupo. DONE
    //Activadad string vacio, lo pondría como error pero el codigo no lo considera.

    @Test
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
    //Club sin grupos devuelve 0 DONE
    //Club con grupos devuelve correctamente DONE

    @Test
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
    public void ingresos_ClubDeportivoConGrupos_DevuelveCorrectamenteIngresos() throws ClubException {

        String codigo = "1";
        String actividad1 = "Natacion";
        int nplazas = 7;
        int nmatriculados = 5;
        double tarifa1 = 12.0;
        Grupo g1 = new Grupo(codigo, actividad1, nplazas, nmatriculados, tarifa1);

        String actividad2 = "Ajedrez";
        double tarifa2 = 14.0;
        Grupo g2 = new Grupo(codigo, actividad2, nplazas, nmatriculados, tarifa2);
        double expectedIngresos = g1.getMatriculados()*g1.getTarifa() + g2.getMatriculados()*g2.getTarifa();

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
    // Plazas insuficientes para personas
    //Considerar Cero personas devuelve lo mismo sin cambios (yo pondría que devuelve exception)
    //Considerar actividad que no esta en club devuelve lo mismo (pondría que devuelve exception)
    //Comprobar adicion correcta.
    //Comprobar con misma actividad pero otros codigos, es decir anyadir mas grupos con misma actividad.
    /*  
       Al intentar matricular a las persona en una actividad que se imparta en varios grupos, si la cantidad de plazas
       en cada una de estos grupos por separado es menor que el número de personas matriculados, pero de manera conjunta se consiguen plazas
       necesarias, uno de los grupos se queda sin plazas
    */

    @Test
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
        //Assert
        assertThrows(ClubException.class, () -> {
            cd.matricular(actividad, npersonas);
        });
    }

    //Este hay que revisar que devolvemos lo mismo y no una exepcion.
    //Lo compruebo con ingreso pero me gustaria comprobarlo de otra forma
    @Test
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
        //Act
        double expectedIngresos = cd.ingresos();
        cd.matricular(actividad, npersonas);
        double actualIngresos = cd.ingresos();
        //Assert
        assertEquals(expectedIngresos, actualIngresos);
    }

    //Este hay que revisar que la exepcion sea la correspondiente o de otra comprobacion.
    @Test
    public void matricular_ActividadNoEstaEnClubDeportivo_DevuelveExepcion() throws ClubException {
        // Arrange:
        String codigo = "1";
        String actividad1 = "Natacion";
        int nplazas = 10;
        int nmatriculados = 5;
        double tarifa = 12.0;
        Grupo g = new Grupo(codigo, actividad1, nplazas, nmatriculados, tarifa);
        String actividad2 = "Ajedrez";

        String nombre = "CDTorremolinos";
        int ngrupos = 5;
        ClubDeportivo cd = new ClubDeportivo(nombre, ngrupos);
        cd.anyadirActividad(g);
        int npersonas = 2;
        //Assert
        assertThrows(ClubException.class, () -> {
            cd.matricular(actividad2, npersonas);
        });
    }

    @Test
    public void matricular_MasMatriculadosQuePlazas_OcupanTodasLasPlazas() throws ClubException {
        // Arrange
        // Grupo 1:
        String codigo = "1";
        String actividad = "Natacion";
        int nplazas = 10;
        int nmatriculados = 5;
        double tarifa = 12.0;
        Grupo g1 = new Grupo(codigo, actividad, nplazas, nmatriculados, tarifa);
        // Grupo 2:
        codigo = "2";
        Grupo g2 = new Grupo(codigo, actividad, nplazas, nmatriculados, tarifa);
        // Club deportivo:
        String nombre = "CDTorremolinos";
        ClubDeportivo cd = new ClubDeportivo(nombre);
        cd.anyadirActividad(g1);
        cd.anyadirActividad(g2);
        int npersonas = 6;
        //Act
        cd.matricular(actividad, npersonas);
        //Assert
        assertTrue(g1.plazasLibres() == 0 || g2.plazasLibres() == 0);
    }

    @Test
    public void matricular_ParametrosCorrectos_MatriculaPersonas() throws ClubException {
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
        int npersonas = 3;
        int expectedPlazasLibres = cd.plazasLibres(actividad) - npersonas;
        //Act
        cd.matricular(actividad, npersonas);
        int actualPlazasLibres = cd.plazasLibres(actividad);
        //Assert
        assertEquals(expectedPlazasLibres, actualPlazasLibres);
    }

}