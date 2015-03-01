
public class Cliente {
	public static void main(String[] params) {
		// ¿paso en el constructor el precio y la potencia o vienen ya dados?
		Equipo d = new Disco("Seagate K139",100,400); 
		Equipo t = new Tarjeta("Kingston L194",200,300);
		Equipo b = new Bus("Alsina (?)",10,50);
		VisitanteEquipo vp = new VisitantePrecio();
		VisitanteNombre vn = new VisitanteNombre();
		
		d.aceptar(vp);
		t.aceptar(vp);
		b.aceptar(vp);
		
		System.out.println("Precio sin descuento: " + ((VisitantePrecio)vp).precio()
				+ "\nComponentes comprados: ");
		d.aceptar(vn);
		t.aceptar(vn);
		b.aceptar(vn);
	}
}
