
public class Cliente {
	public static void main(String[] params) {
		// ¿paso en el constructor el precio y la potencia o vienen ya dados?
		Disco d = new Disco("Seagate K139",100,400); 
		Tarjeta t = new Tarjeta("Kingston L194",200,300);
		Bus b = new Bus("Alsina (?)",10,50);
		VisitantePrecio vp = new VisitantePrecio();
		
		d.aceptar(vp);
		t.aceptar(vp);
		b.aceptar(vp);
		
		System.out.println("El precio total es: " + vp.precio());
	}
}
