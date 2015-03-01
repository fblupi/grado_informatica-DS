
public class Disco extends Equipo {
	private double potencia; // ¿qué es?
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
		return precio; // ¿Habría que pasar como parámetro el descuento?
	}
	public void aceptar(VisitanteEquipo ve) {
		ve.visitarDisco(this);
	}
}
