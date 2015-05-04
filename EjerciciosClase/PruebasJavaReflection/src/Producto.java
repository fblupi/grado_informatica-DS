
public class Producto {
	public String nombre;
	private String nombreSimple = null;
	private int cantidad = 1;
	
	public Producto(String nombre) {
		this.nombre = nombre;
	}
	
	public void setNombreSimple(String nombreSimple) {
		this.nombreSimple = nombreSimple;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public String getNombre() {
		if(nombreSimple == null) {
			return nombre;
		} else {
			return nombreSimple;
		}
	}
}
