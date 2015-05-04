
public class Producto {
	public String nombre;
	private String nombreSimple = null;
	
	public Producto(String nombre) {
		this.nombre = nombre;
	}
	
	public void setNombreSimple(String nombreSimple) {
		this.nombreSimple = nombreSimple;
	}
	
	public String getNombre() {
		if(nombreSimple == null) {
			return nombre;
		} else {
			return nombreSimple;
		}
	}
}
