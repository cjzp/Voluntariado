package beans;

/*
 * `cod_doc` varchar(14) NOT NULL,
  `cod_usu` varchar(11) NOT NULL references tb_usuario,
  */

public class DocenteDTO {
	
	private String codigo;
	private String codigo_usu;

	
	public DocenteDTO(String codigo, String codigo_usu) {
		super();
		this.codigo = codigo;
		this.codigo_usu = codigo_usu;
	
	}

	public DocenteDTO() {
		super();
	}



	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCod_usuario() {
		return codigo_usu;
	}

	public void setCod_usuario(String cod_usuario) {
		this.codigo_usu = cod_usuario;
	}

	@Override
	public String toString() {
		return "DocenteDTO [codigo=" + codigo + ", codigo_usu=" + codigo_usu + "]";
	}

	
	
	
	

}
