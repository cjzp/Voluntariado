package interfaces;

import java.util.List;

import beans.UsuarioDTO;

public interface UsuarioDAO
{
	public UsuarioDTO iniciarSesion(String login);

	public int insertarUsuario(UsuarioDTO usuario);

	public List<UsuarioDTO> listarUsuarios();

	int actualizarUsuario(UsuarioDTO obj);


	int eliminarUsuario(String codigo);

	UsuarioDTO buscarCodigoUsuario(String cod);
		
	public void habilitarUsuario(String codigo, boolean habilitado);
	
	public void cambiarPass(String codigo,String nuevoPass);
}
