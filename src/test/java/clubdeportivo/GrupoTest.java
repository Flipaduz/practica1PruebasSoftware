package clubdeportivo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;

public class GrupoTest {

    // Constructor:
    // No podemos crear grupo con plazas negativas DONE
    // No podemos crear grupo con cero plazas DONE
    // No podemos crear grupo con número de matriculados negativo DONE
    // No podemos crear grupo con tarifa cero DONE
    // No podemos crear grupo con tarifa negativa DONE
    // No podemos crear un grupo  si el número de matriculados supera las plazas disponibles DONE
    // Si todos los datos son correctos, se crea el grupo 


    @Test
    @DisplayName("No podemos crear grupo con plazas negativas")
    public void Grupo_plazasNegativas_DevolvemosExcepcion(){
        // Arrange:
        String codigo = "1";
        String actividad = "Natación";
        int nplazas = -5;
        int nmatriculados = 5;
        double tarifa = 12;
        // Assert & Act:        
        assertThrows(ClubException.class, ()->{
            new Grupo(codigo, actividad, nplazas, nmatriculados, tarifa);
        });
    }

    @Test
    @DisplayName("No podemos crear grupo con cero plazas")
    public void Grupo_CeroPlazas_DevolvemosExcepcion(){
        // Arrange:
        String codigo = "1";
        String actividad = "Natación";
        int nplazas = 0;
        int nmatriculados = 5;
        double tarifa = 12;
        // Assert & Act:        
        assertThrows(ClubException.class, ()->{
            new Grupo(codigo, actividad, nplazas, nmatriculados, tarifa);
        });
    }

    @Test
    @DisplayName("No podemos crear grupo con número de matriculados negativo")
    public void Grupo_MatriculadosNegativo_DevolvemosExcepcion(){
        // Arrange:
        String codigo = "1";
        String actividad = "Natación";
        int nplazas = 10;
        int nmatriculados = -5;
        double tarifa = 12;
        // Assert & Act:        
        assertThrows(ClubException.class, ()->{
            new Grupo(codigo, actividad, nplazas, nmatriculados, tarifa);
        });
    }

    @Test
    @DisplayName("No podemos crear grupo con tarifa cero")
    public void Grupo_TarifCero_DevolvemosExcepcion(){
        // Arrange:
        String codigo = "1";
        String actividad = "Natación";
        int nplazas = 10;
        int nmatriculados = 5;
        double tarifa = 0;
        // Assert & Act:        
        assertThrows(ClubException.class, ()->{
            new Grupo(codigo, actividad, nplazas, nmatriculados, tarifa);
        });
    }

    @Test
    @DisplayName("No podemos crear grupo con tarifa negativa")
    public void Grupo_TarifaNegativa_DevolvemosExcepcion(){
        // Arrange:
        String codigo = "1";
        String actividad = "Natación";
        int nplazas = 10;
        int nmatriculados = 5;
        double tarifa = -10;
        // Assert & Act:        
        assertThrows(ClubException.class, ()->{
            new Grupo(codigo, actividad, nplazas, nmatriculados, tarifa);
        });
    }

    @Test
    @DisplayName("No podemos crear grupo con más matriculados que plazos")
    public void Grupo_MasMatriculadosQuePlazas_DevolvemosExcepcion(){
        // Arrange:
        String codigo = "1";
        String actividad = "Natación";
        int nplazas = 10;
        int nmatriculados = 50;
        double tarifa = 10;
        // Assert & Act:        
        assertThrows(ClubException.class, ()->{
            new Grupo(codigo, actividad, nplazas, nmatriculados, tarifa);
        });
    }

    @Test
    @DisplayName("Si los datos son correctos se crea el grupo con los datos proporcionados")
    public void Grupo_DatosCorrectos_SeCreaElGrupo() throws ClubException{
        //Arrange:
        String codigo = "1";
        String actividad = "Natación";
        int nplazas = 10;
        int nmatriculados = 5;
        double tarifa = 10;
        // Act:
        Grupo g = new Grupo(codigo, actividad, nplazas, nmatriculados, tarifa);
        //Assert:        
        assertTrue(codigo.equals(g.getCodigo()));
        assertTrue(actividad.equals(g.getActividad()));
        assertTrue(nplazas == g.getPlazas());
        assertTrue(nmatriculados == g.getMatriculados());
        assertTrue(tarifa == g.getTarifa());
        assertTrue(codigo.toUpperCase().hashCode()+actividad.toUpperCase().hashCode() == g.hashCode());
        
    }

    // Método #1: plazasLibres
    // ------------------------
    // Si no hay plazas libres devolvemos 0 DONE
    // Si hay plazas libres devolvemos el número de plazas libres DONE

    @Test
    @DisplayName("Si no hay plazas libres devolvemos 0")
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

    @Test
    @DisplayName("Si hay plazas libres devolvemos el número de plazas libres")
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
    // -------------------------------------------------------------
    // Si intentamos actualizar el número de plazas con valor negativo, devolvemos excepción DONE
    // Si intentamos actualizar el número de plazas con un valor nulo, devolvemos excepción DONE
    // Si intentamos actualizar el número de plazas con el número menor que el número de matriculados, devolvemos excepción DONE
    // Si intentamos actualizar el número de plazas con un número mayor que el de plazas número de matriculados, se actualiza el número de de plazas DONE


    @Test
    @DisplayName("Si intentamos actualizar el número de plazas con valor negativo, devolvemos excepción")
    public void actualizarPlazas_PlazasNegativas_DevuelveExcepcion() throws ClubException
    {
         // Arrange:
         String codigo = "1";
         String actividad = "Natación";
         int nplazas = 7;
         int nmatriculados = 5;
         double tarifa = 12;
         Grupo g = new Grupo(codigo, actividad, nplazas, nmatriculados, tarifa);
         
         // Act & Assert:
         assertThrows(ClubException.class, ()->{
            g.actualizarPlazas(-1);
         });        
    }


    @Test
    @DisplayName("Si el número de plazas se actualiza con cero , devolvemos excepción")
    public void actualizarPlazas_CeroPlazas_DevuelveExcepcion() throws ClubException
    {
        // Arrange:
        String codigo = "1";
        String actividad = "Natación";
        int nplazas = 7;
        int nmatriculados = 5;
        double tarifa = 12;
        Grupo g = new Grupo(codigo, actividad, nplazas, nmatriculados, tarifa);

        // Act & Assert:
        assertThrows(ClubException.class, ()->{
            g.actualizarPlazas(0);
        });
    }

    @Test
    @DisplayName("Si el número de plazas es menor que el número de matriculados, devolvemos excepción")
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

    @Test
    @DisplayName("Si el número de plazas supera el número de matriculados, se actualiza el número de de plazas")
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

    // Si se intenta matricular el número negativo de personas, devolvemos excepción DONE
    // Si se intentan matricular cero personas, devolvemos excepción DONE
    // Si al intentar matricular n personas, sobrepasamos plazas disponibles, devolvemos excepción DONE
    // Si hay plazas disponibles, matriculamos a las personas. DONE
    
    @Test
    @DisplayName("Si se intenta matricular el número negativo de personas, devolvemos excepción")
    public void matricular_NumeroDeMatriculadosNegativo_DevuelveExcepcion() throws ClubException{
        // Arrange:
        String codigo = "1";
        String actividad = "Natación";
        int nplazas = 7;
        int nmatriculados = 5;
        double tarifa = 12;
        Grupo g = new Grupo(codigo, actividad, nplazas, nmatriculados, tarifa);        
        // Act & Assert:
        assertThrows(ClubException.class, ()->{
            g.matricular(-12);
        });
    }

    
    @Test
    @DisplayName("Si se intentan matricular cero personas, devolvemos excepción")
    public void matricular_NumeroDeMatriculadosCero_DevuelveExcepcion() throws ClubException{
        // Arrange:
        String codigo = "1";
        String actividad = "Natación";
        int nplazas = 7;
        int nmatriculados = 5;
        double tarifa = 12;
        Grupo g = new Grupo(codigo, actividad, nplazas, nmatriculados, tarifa);

        // Act & Assert:
        assertThrows(ClubException.class, ()->{
            g.matricular(0);
        });
    }

    
    @Test
    @DisplayName("Si sobrepasamos las plazas disponible, devolvemos una excepción ")
    public void matricular_SuperaPlazas_DevuelveExcepcion() throws ClubException{
        // Arrange:
        String codigo = "1";
        String actividad = "Natación";
        int nplazas = 7;
        int nmatriculados = 5;
        double tarifa = 12;
        Grupo g = new Grupo(codigo, actividad, nplazas, nmatriculados, tarifa);

        // Act &Assert:
        assertThrows(ClubException.class, ()->{
            g.matricular(12);
        });
    }

    
    @Test
    @DisplayName("Si hay plazas, actualizamos el número de matriculados en el grupo ")
    public void matricular_HayPlazas_ActualizamosElNumeroDeMatriculados() throws ClubException{
        // Arrange:
        String codigo = "1";
        String actividad = "Natación";
        int nplazas = 7;
        int nmatriculados = 5;
        double tarifa = 12;
        Grupo g = new Grupo(codigo, actividad, nplazas, nmatriculados, tarifa);
        int nuevosMatriculados = 2; // Deseamos matricular 2 personas
        // Act:
        g.matricular(nuevosMatriculados);
        // Assert:
        assertEquals(nmatriculados + nuevosMatriculados, g.getMatriculados());
    }
}
