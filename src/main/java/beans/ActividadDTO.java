package beans;

import java.sql.Date;

public class ActividadDTO 
{
	private int codigo;
	private int cod_institucion;
	private String nombre;
	private String nom_institucion;
	private String descripcion;
	private Date fecha;
	private String horaInicio;
	private String horaFin;
	private String cod_docente;
	private String nom_usuario;
	private int codEstado; //1 aprobado 2 en revision 3 descartado
	private String nombreEstado;
	private String motivoEstado;
	
	private int vacantesMin;
	private int vacantesMax;
		
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCod_institucion() {
		return cod_institucion;
	}
	public void setCod_institucion(int cod_institucion) {
		this.cod_institucion = cod_institucion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNom_institucion() {
		return nom_institucion;
	}
	public void setNom_institucion(String nom_institucion) {
		this.nom_institucion = nom_institucion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}
	public String getCod_docente() {
		return cod_docente;
	}
	public void setCod_docente(String cod_docente) {
		this.cod_docente = cod_docente;
	}
	public String getNom_usuario() {
		return nom_usuario;
	}
	public void setNom_usuario(String nom_docente) {
		this.nom_usuario = nom_docente;
	}
	public int getCodEstado() {
		return codEstado;
	}
	public void setCodEstado(int codEstado) {
		this.codEstado = codEstado;
	}
	public String getNombreEstado() {
		return nombreEstado;
	}
	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}
	public String getMotivoEstado() {
		return motivoEstado;
	}
	public void setMotivoEstado(String motivoEstado) {
		this.motivoEstado = motivoEstado;
	}
	public int getVacantesMin() {
		return vacantesMin;
	}
	public void setVacantesMin(int vacantesMin) {
		this.vacantesMin = vacantesMin;
	}
	public int getVacantesMax() {
		return vacantesMax;
	}
	public void setVacantesMax(int vacantesMax) {
		this.vacantesMax = vacantesMax;
	}
	
	
}
