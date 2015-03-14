
public class Cliente {
	public static void main(String[] params) {
		Equipo d = new Disco("Seagate K139",100,400); 
		Equipo t = new Tarjeta("Kingston L194",200,300);
		Equipo b = new Bus("Acer H3i12",10,50);
		VisitanteEquipo vp = new VisitantePrecio();
		VisitanteNombre vn = new VisitanteNombre();
		
		d.aceptar(vp);
		t.aceptar(vp);
		b.aceptar(vp);
		System.out.println("Precio sin descuento: " + ((VisitantePrecio)vp).precio());
		
		System.out.println("\nComponentes comprados: ");
		d.aceptar(vn);
		t.aceptar(vn);
		b.aceptar(vn);
	}
}
