
public class Bus extends Equipo {
	private double potencia; // �qu� es?
	private double precio;
	Bus(String nombre, double precio, double potencia) {
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
		return precio; // �Habr�a que pasar como par�metro el descuento?
	}
	public void aceptar(VisitanteEquipo ve) {
		ve.visitarBus(this);
	}
}