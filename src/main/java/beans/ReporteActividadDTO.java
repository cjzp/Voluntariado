package beans;

import java.sql.Date;


public class ReporteActividadDTO {

	private String nom_institucion;
	private String nom_actividad;
	private String desc_act;
	private Date fecha_act;
	private String horaInicio;
	private String horaFin;
	private String nom_docente;
	private String nom_estado;
	private String motivo_estado;
	private int vacantes;
	public String getNom_institucion() {
		return nom_institucion;
	}
	public void setNom_institucion(String nom_institucion) {
		this.nom_institucion = nom_institucion;
	}
	public String getNom_actividad() {
		return nom_actividad;
	}
	public void setNom_actividad(String nom_actividad) {
		this.nom_actividad = nom_actividad;
	}
	public String getDesc_act() {
		return desc_act;
	}
	public void setDesc_act(String desc_act) {
		this.desc_act = desc_act;
	}
	public Date getFecha_act() {
		return fecha_act;
	}
	public void setFecha_act(Date fecha_act) {
		this.fecha_act = fecha_act;
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
	public String getNom_docente() {
		return nom_docente;
	}
	public void setNom_docente(String nom_docente) {
		this.nom_docente = nom_docente;
	}
	public String getNom_estado() {
		return nom_estado;
	}
	public void setNom_estado(String nom_estado) {
		this.nom_estado = nom_estado;
	}
	public String getMotivo_estado() {
		return motivo_estado;
	}
	public void setMotivo_estado(String motivo_estado) {
		this.motivo_estado = motivo_estado;
	}
	public int getVacantes() {
		return vacantes;
	}
	public void setVacantes(int vacantes) {
		this.vacantes = vacantes;
	}
	@Override
	public String toString() {
		return "ReporteActividadDTO [nom_institucion=" + nom_institucion + ", nom_actividad=" + nom_actividad
				+ ", desc_act=" + desc_act + ", fecha_act=" + fecha_act + ", horaInicio=" + horaInicio + ", horaFin="
				+ horaFin + ", nom_docente=" + nom_docente + ", nom_estado=" + nom_estado + ", motivo_estado="
				+ motivo_estado + ", vacantes=" + vacantes + "]";
	}

	
	
}
