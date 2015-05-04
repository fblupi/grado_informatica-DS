import java.lang.reflect.*;

public class Interprete {
	private Class clase;
	private Field[] fields;
	private Method[] methods;
	
	public Interprete(String nombreClase) {
		try {
			this.clase = Class.forName(nombreClase); // Obtiene clase
			this.fields = this.clase.getDeclaredFields(); // Obtiene atributos
			this.methods = this.clase.getDeclaredMethods(); // Obtiene métodos
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public String printName() {
		return "Nombre de clase: " + this.clase + "\n\n";
	}
	
	public String printFields() {
		String salida = new String("");
		for(Field field: this.fields) {
			field.setAccessible(true); // Para poder acceder a los private
			String fieldName = field.getName(); // Obtiene nombre
			Object fieldType = field.getType(); // Obtiene tipo
			salida += ("Atributo\nNombre: " + fieldName + "\nTipo: " + fieldType + "\n\n");
		}
		return salida;
	}
	
	public String printMethods() {
		String salida = new String("");
		for(Method method: this.methods) {
			method.setAccessible(true); // Para poder acceder a los private
			String methodName = method.getName(); // Obtiene nombre
			Object methodType = method.getReturnType(); // Obtiene tipo
			salida += ("Método\nNombre:" + methodName + "\nTipo: " + methodType + "\n\n");
		}
		return salida;
	}
}
