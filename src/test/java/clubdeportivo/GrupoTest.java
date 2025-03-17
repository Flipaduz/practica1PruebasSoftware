package clubdeportivo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;

public class GrupoTest {

    // Método #1: plazasLibres
    // ------------------------

    // Si no hay plazas libres devolvemos 0 
     @Test
    public void plazasLibres_TodasPlazasCubiertas_DevuelveCeroPlazasLibres() throws ClubException{
        // Arrange:
        String codigo = "1";
        String actividad = "Natación";
        int nplazas = 5;
        int nmatriculados = 5;
        double tarifa = 12;
        Grupo g = new Grupo(codigo, actividad, nplazas, nmatriculados, tarifa);
        // Act:
        int plazasLibres = g.plazasLibres();
        // Assert:
        assertEquals(0, plazasLibres);
    }


    // Si hay plazas libres devolvemos el número de plazas libres
    @Test
    public void plazasLibres_NoTodasPlazasCubiertas_DevuelvePlazasLibres() throws ClubException{
         // Arrange:
         String codigo = "1";
         String actividad = "Natación";
         int nplazas = 7;
         int nmatriculados = 5;
         double tarifa = 12;
         Grupo g = new Grupo(codigo, actividad, nplazas, nmatriculados, tarifa);
         
         // Act:
         int plazasLibres = g.plazasLibres();
         
         // Assert:
         assertEquals(nplazas - nmatriculados, plazasLibres);

    }

    // Metodo #2: actualizarPlazas
    // ----------------------------

    // Si el número de plazas se actualiza con un valor negativo, devolvemos excepción
    @Test
    public void actualizarPlazas_PlazasNegativas_DevuelveExcepcion() throws ClubException
    {
         // Arrange:
         String codigo = "1";
         String actividad = "Natación";
         int nplazas = 7;
         int nmatriculados = 5;
         double tarifa = 12;
         Grupo g = new Grupo(codigo, actividad, nplazas, nmatriculados, tarifa);
         
         // Assert:
         assertThrows(ClubException.class, ()->{
            g.actualizarPlazas(-1);
         });        
    }

    // Si el número de plazas se actualiza con un valor cero, devolvemos excepción
    @Test
    public void actualizarPlazas_CeroPlazas_DevuelveExcepcion() throws ClubException
    {
        // Arrange:
        String codigo = "1";
        String actividad = "Natación";
        int nplazas = 7;
        int nmatriculados = 5;
        double tarifa = 12;
        Grupo g = new Grupo(codigo, actividad, nplazas, nmatriculados, tarifa);

        // Assert:
        assertThrows(ClubException.class, ()->{
            g.actualizarPlazas(0);
        });
    }

    // Si el número de plazas es menor que el número de matriculados, devolvemos excepción
    @Test
    public void actualizarPlazas_MasMatriculadosQuePlazas_DevuelveExcepcion() throws ClubException
    {
         // Arrange:
         String codigo = "1";
         String actividad = "Natación";
         int nplazas = 7;
         int nmatriculados = 5;
         double tarifa = 12;
         Grupo g = new Grupo(codigo, actividad, nplazas, nmatriculados, tarifa);
         
         // Assert:
         assertThrows(ClubException.class, ()->{
            g.actualizarPlazas(4);
         });        
    }

    // Si el número de plazas supera el número de matriculados, se actualiza el número de de plazas
    @Test
    public void actualizarPlazas_PlazasSuperanMatriculados_NuevoNumeroDePlazas() throws ClubException
    {
         // Arrange:
         String codigo = "1";
         String actividad = "Natación";
         int nplazas = 7;
         int nmatriculados = 5;
         double tarifa = 12;
         Grupo g = new Grupo(codigo, actividad, nplazas, nmatriculados, tarifa);

         // Nuevo número de plazas
         int nuevas_plazas = 8;

         // Act:        
         g.actualizarPlazas(nuevas_plazas);
         
         // Assert:
         assertEquals(nuevas_plazas, g.getPlazas());                
    }

    // Metodo #3: matricular
    // ----------------------

    // Si se intenta matricular el número negativo de personas, devolvemos excepción
    @Test
    public void matricular_NumeroDeMatriculadosNegativo_DevuelveExcepcion() throws ClubException{
        // Arrange:
        String codigo = "1";
        String actividad = "Natación";
        int nplazas = 7;
        int nmatriculados = 5;
        double tarifa = 12;
        Grupo g = new Grupo(codigo, actividad, nplazas, nmatriculados, tarifa);
        
        // Assert:
        assertThrows(ClubException.class, ()->{
            g.matricular(-12);
        });
    }

    // Si se intentan matricular cero personas, devolvemos excepción
    @Test
    public void matricular_NumeroDeMatriculadosCero_DevuelveExcepcion() throws ClubException{
        // Arrange:
        String codigo = "1";
        String actividad = "Natación";
        int nplazas = 7;
        int nmatriculados = 5;
        double tarifa = 12;
        Grupo g = new Grupo(codigo, actividad, nplazas, nmatriculados, tarifa);

        // Assert:
        assertThrows(ClubException.class, ()->{
            g.matricular(0);
        });
    }

    // Si se pasan las plazas, devolvemos excepción
    @Test
    public void matricular_SuperaPlazas_DevuelveExcepcion() throws ClubException{
        // Arrange:
        String codigo = "1";
        String actividad = "Natación";
        int nplazas = 7;
        int nmatriculados = 5;
        double tarifa = 12;
        Grupo g = new Grupo(codigo, actividad, nplazas, nmatriculados, tarifa);

        // Assert:
        assertThrows(ClubException.class, ()->{
            g.matricular(12);
        });
    }

    // Si hay plazas, actualizamos el número de matriculados en el grupo
    @Test
    public void matricular_HayPlazas_ActualizamosElNumeroDeMatriculados() throws ClubException{
        // Arrange:
        String codigo = "1";
        String actividad = "Natación";
        int nplazas = 7;
        int nmatriculados = 5;
        double tarifa = 12;
        Grupo g = new Grupo(codigo, actividad, nplazas, nmatriculados, tarifa);

        int nuevosMatriculados = 2;

        // Act:
        g.matricular(nuevosMatriculados);

        // Assert:
        assertEquals(nmatriculados + nuevosMatriculados, g.getMatriculados());
    }
}
