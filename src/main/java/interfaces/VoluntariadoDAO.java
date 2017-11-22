package interfaces;

import java.util.List;

import beans.VoluntariadoDTO;

public interface VoluntariadoDAO 
{
	public int actualizarVoluntariado(VoluntariadoDTO obj);
	public VoluntariadoDTO buscarVoluntariado(int cod);
	public List<VoluntariadoDTO> listarVoluntarios();
	public int registrarVoluntariado(VoluntariadoDTO obj);
	public int eliminarVoluntariado(int cod);
	public List<VoluntariadoDTO> buscarPorActividad(String nombreActividad);
	public List<VoluntariadoDTO> buscarPorAlumno(String codigoAlumno);
	public List<VoluntariadoDTO> controlDeAlumno(String codigoAlumno);
	public List<VoluntariadoDTO> buscarHorasAlumno(String codigoAlumno);
	List<VoluntariadoDTO> buscarPorSeccion(String seccion);
}
