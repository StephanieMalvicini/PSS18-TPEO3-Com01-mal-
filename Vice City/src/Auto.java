import java.awt.Color;

public class Auto {
	private String patente;
	private float valor;
	private boolean robado;
	private Color color;
	private String marca;
	private int capacidad;
	
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public boolean isRobado() {
		return robado;
	}
	public void setRobado(boolean robado) {
		this.robado = robado;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
	
}
