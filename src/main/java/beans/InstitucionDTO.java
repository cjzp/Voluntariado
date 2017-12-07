package beans;

public class InstitucionDTO 
{
	private int codigo;
	private String nombre;
	private String caracteristicas;
	private String direccion;
	private String telefono;
	
	private String comentarios;
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	private int calificacion;
	
	public int getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCaracteristicas() {
		return caracteristicas;
	}
	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	@Override
	public String toString() {
		return "InstitucionDTO [codigo=" + codigo + ", nombre=" + nombre + ", caracteristicas=" + caracteristicas
				+ ", direccion=" + direccion + ", telefono=" + telefono + ", comentarios=" + comentarios
				+ ", calificacion=" + calificacion + "]";
	}
	
	
	
}
