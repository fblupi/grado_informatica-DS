
public class VisitantePrecio extends VisitanteEquipo {
	private double precio;
	VisitantePrecio() {
		super();
		precio = 0;
	}
	public void visitarDisco(Disco d) {
		precio += d.precioNeto();
	}
	public void visitarTarjeta(Tarjeta t) {
		precio += t.precioNeto();
	}
	public void visitarBus(Bus b) {
		precio += b.precioNeto();
	}
	public double precio() {
		return precio;
	}
}
