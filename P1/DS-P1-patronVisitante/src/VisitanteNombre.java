
public class VisitanteNombre extends VisitanteEquipo {
	public void visitarDisco(Disco d) {
		System.out.println(d.nombre());
	}
	
	public void visitarTarjeta(Tarjeta t) {
		System.out.println(t.nombre());
	}
	
	public void visitarBus(Bus b) {
		System.out.println(b.nombre());
	}
}
