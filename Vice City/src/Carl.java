import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class Carl {
	private static int numPatente;
	private Ciudad ciud;
	
	private static Carl instance;
	
	public static Carl getInstance() {
		if (instance==null)
			instance = new Carl();
		return instance;
	}
	
	private Carl() {
		numPatente = 0;
	}
	
	public Auto buscarAuto() {
		Collection<Auto> lista = ciud.getAutos();
		Iterator<Auto> it = lista.iterator();
		Auto aux = null;
		boolean encontre = false;
		while (it.hasNext() && !encontre)
		{
			aux = it.next();
			if(Tommy.getInstance().puedePagar(aux.getValor())) {
				encontre = true;
				Tommy.getInstance().pagar(aux.getValor());
			}
		}
		
		
		
		
	}
}
