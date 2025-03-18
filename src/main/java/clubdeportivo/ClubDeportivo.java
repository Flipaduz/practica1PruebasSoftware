//Realizado por:
//Ángel Bayón Pazos
//Daniil Gumeniuk
//
package clubdeportivo;

import java.util.StringJoiner;

public class ClubDeportivo {
	private String nombre;
	private int ngrupos;
	private Grupo[] grupos;
	private static final int TAM = 10; // Tamaño del grupo por defecto

	// Constructor para crear el club con el tamaño por defecto
	public ClubDeportivo(String nombre) throws ClubException {
		this(nombre, TAM);
	}
	// Constructor para crear el club con el número de grupos determinado
	public ClubDeportivo(String nombre, int n) throws ClubException {
		if (n <= 0) {
			throw new ClubException("ERROR: el club no puede crearse con un número de grupos 0 o negativo");
		}
		this.nombre = nombre;
		grupos = new Grupo[n];
	}

	private int buscar(Grupo g) {
		int i = 0;
		while (i < ngrupos && !g.equals(grupos[i])) {
			i++;
		}
		if (i == ngrupos) {
			i = -1;
		}
		return i;
	}

	// Añade actividad con los datos del grupo donde se va a impartir 
	public void anyadirActividad(String[] datos) throws ClubException {
		try {
			if(datos == null){ // Corrección #1: arreglo nulo
				throw new ClubException("ERROR: los datos para añadir actividad son nulos");
			}
			else if(datos.length < 5){ // Corrección #2: datos insuficiente
				throw new ClubException("ERROR: no hay datos suficiente para añadir nueva actividad");
			}
			// Corrección #3.1:  Elementos del array nulos
			else if (datos[0] == null){ 
				throw new ClubException("ERROR: Los datos no pueden ser nulos");
			}
			else if(datos[1] == null){
				throw new ClubException("ERROR: Los datos no pueden ser nulos");
			}			
			int plazas = Integer.parseInt(datos[2]);
			int matriculados = Integer.parseInt(datos[3]);
			double tarifa = Double.parseDouble(datos[4]);
			Grupo g = new Grupo(datos[0], datos[1], plazas, matriculados, tarifa);
			anyadirActividad(g);

		}// Corrección #3.2:  Elementos del array nulos 
		catch (NumberFormatException e) { 
			throw new ClubException("ERROR: formato de número incorrecto");
		}catch(NullPointerException e){  // Corrección #3: si los datos son nulos lanza una excepción
			throw new ClubException("ERROR: Los datos no pueden ser nulos");
		}
	}

	// Añadimos actividad, añadiendo el grupo directamente
	public void anyadirActividad(Grupo g) throws ClubException {
		if (g==null){ // Correción #4: anaydido para comprobar los grupos nulos
			throw new ClubException("ERROR: el grupo es nulo");
		}
		int pos = buscar(g);
		if (pos == -1) { // El grupo es nuevo
			// Correción #5: hay que manejar la situación cuando nos hemos pasado del límite de grupos permitidos
			if(ngrupos == grupos.length){
				throw new ClubException("ERROR: No se puede añadir más grupos de lo que nos permite el club");
			}
			grupos[ngrupos] = g;
			ngrupos++;
		} else { // El grupo ya existe --> modificamos las plazas
			grupos[pos].actualizarPlazas(g.getPlazas());
		}
	}

	// Métodod que devuelve plazas libres de la actividad que se le pasa como parametro
	public int plazasLibres(String actividad) {
		int p = 0;
		int i = 0;
		while (i < ngrupos) {
			if (grupos[i].getActividad().equals(actividad)) {
				p += grupos[i].plazasLibres();
			}
			i++;
		}
		return p;
	}
	//  Métodod que matricula a las "npersonas" en la "actividad"
	public void matricular(String actividad, int npersonas) throws ClubException {
		int plazas = plazasLibres(actividad);
		if (plazas < npersonas) {
			throw new ClubException("ERROR: no hay suficientes plazas libres para esa actividad en el club.");
		}
		int i = 0;
		while (i < ngrupos && npersonas > 0) {
			if (actividad.equals(grupos[i].getActividad())) {   // Recorremos todos los grupos en los que se imparte esta actividad
				int plazasGrupo = grupos[i].plazasLibres();     // Obtenemos plazas libres del grupo
				if (npersonas >= plazasGrupo) {  			    // Comprobamos si las personas caben en el grupo
					grupos[i].matricular(plazasGrupo);  		// Matriculamos a los que podamos
					npersonas -= plazasGrupo;					// El resto tiene que buscar otro grupo
				} else {
					grupos[i].matricular(npersonas);
				}
			}
			i++;
		}
	}

	public double ingresos() {
		double cantidad = 0.0;
		int i = 0;
		while (i < ngrupos) {
			cantidad += grupos[i].getTarifa() * grupos[i].getMatriculados();
			i++;
		}
		return cantidad;
	}

	public String toString() {
		StringJoiner sj = new StringJoiner(", ", "[ ", " ]");
		int i = 0;
		while (i < ngrupos) {
			sj.add(grupos[i].toString());
			i++;
		}
		return nombre + " --> " + sj.toString();
	}
}
