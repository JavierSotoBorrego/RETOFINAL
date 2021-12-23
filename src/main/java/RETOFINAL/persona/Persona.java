package RETOFINAL.persona;

public class Persona {
	private String Nombre;
	private String Usuario;
	private String Password;
	
	public Persona() {
		super();
	}
	public Persona(String nombre, String usuario, String password) {
		super();
		Nombre = nombre;
		Usuario = usuario;
		Password = password;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getUsuario() {
		return Usuario;
	}
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	
	
}
