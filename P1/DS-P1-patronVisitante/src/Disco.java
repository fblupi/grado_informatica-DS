
public class Disco extends Equipo {
	private double potencia;
	private double precio;
	
	Disco(String nombre, double precio, double potencia) {
		super(nombre);
		this.precio = precio;
		this.potencia = potencia;
	}
	
	public double potencia() {
		return potencia;
	}
	
	public double precioNeto() {
		return precio;
	}
	
	public double precioConDescuento() {
		return precio;
	}
	
	public void aceptar(VisitanteEquipo ve) {
		ve.visitarDisco(this);
	}
}
