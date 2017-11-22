package beans;

public class ReporteAlumnoDTO {

	private String codigo;
	private String nombre;
	private String apellido;
	private String seccion;
	private String carrera;
	private String telefono;
	private String correo;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getSeccion() {
		return seccion;
	}
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	@Override
	public String toString() {
		return "ReporteAlumnoDTO [codigo=" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", seccion="
				+ seccion + ", carrera=" + carrera + ", telefono=" + telefono + ", correo=" + correo + "]";
	}

	

	
	
}
