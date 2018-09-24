import java.util.Collection;
import java.util.LinkedList;

public class Tommy {
	private float  efectivo;
	private float capital;
	private Collection<Inmueble> inmueblesPropios;
	private static Tommy instance;
	
	public static Tommy getInstance() {
		if (instance==null)
			instance = new Tommy();
		return instance;
	}
	
	
	private Tommy() {
		inmueblesPropios = new LinkedList<Inmueble>();
	}
	
	public void solicitarAuto() {
		if (cantLugares()>0) {
			Carl.getInstance().buscarAuto();
		}
	}
	private int cantLugares() {
		
	}
	
	
	public boolean puedePagar(float n) {
		if (n<=efectivo)
			return true;
		
		return false;
	}
	
	public void pagar(int n) {
		efectivo -= n;
	}
}
