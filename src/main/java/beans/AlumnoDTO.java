package beans;
/*
`cod_alu` varchar(10) NOT NULL,
  `cod_usu` varchar(11) NOT NULL references tb_usuario,
  `cod_carrera` int(3) NOT NULL references tb_carrera,
  `cod_seccion` int(3) NOT NULL references tb_seccion,  
  `cod_act` varchar(11) DEFAULT NULL references tb_actividad, 
 */
public class AlumnoDTO {
	
	private String codigo_usuario;
	private String codigo;
	private int carrera_cod;
	private int seccion_cod;
	private int cod_actividad;
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getCarrera() {
		return carrera_cod;
	}
	@Override
	public String toString() {
		return "AlumnoDTO [codigo_usuario=" + codigo_usuario + ", codigo=" + codigo + ", carrera_cod=" + carrera_cod
				+ ", seccion_cod=" + seccion_cod + ", cod_actividad=" + cod_actividad + "]";
	}
	public void setCarrera(int carrera) {
		this.carrera_cod = carrera;
	}
	public int getSeccion() {
		return seccion_cod;
	}
	public void setSeccion(int seccion) {
		this.seccion_cod = seccion;
	}
	public int getCod_actividad() {
		return cod_actividad;
	}
	public void setCod_actividad(int cod_actividad) {
		this.cod_actividad = cod_actividad;
	}
	
	public String getCodigo_usuario() {
		return codigo_usuario;
	}
	public void setCodigo_usuario(String codigo_usuario) {
		this.codigo_usuario = codigo_usuario;
	}
	
	
	
	
	

}
