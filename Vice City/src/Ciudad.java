import java.util.Collection;
import java.util.LinkedList;

public class Ciudad {
	
	private Collection<Inmueble> inmuebles;
	private Collection<Auto> autos;
	
	public Ciudad() {
		inmuebles = new LinkedList<Inmueble>();
		autos = new LinkedList<Auto>();
	}
	
	public Collection<Inmueble> getInmuebles() {
		return inmuebles;
	}
	public Collection<Auto> getAutos() {
		return autos;
	}


}
