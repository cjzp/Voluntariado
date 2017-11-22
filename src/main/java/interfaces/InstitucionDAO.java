package interfaces;

import java.util.List;

import beans.ComentariosDTO;
import beans.InstitucionDTO;
import beans.InstitucionNombresDTO;
import beans.ReporteComentCalificacionDTO;

public interface InstitucionDAO
{
	public List<InstitucionDTO> listarInstituciones();
	public InstitucionDTO buscarInstitucion(int cod);
	public int registrarInstitucion(InstitucionDTO obj);
	public int actualizarInstitucion(InstitucionDTO obj);
	public int eliminarInstitucion(int cod);
	
	
	public List<ReporteComentCalificacionDTO> listarComentariosCalificacion();
	public int registrarComentariosInstitucion(ComentariosDTO obj);
	public List<InstitucionNombresDTO> listarInstitucionNombres();
	public ComentariosDTO buscarInstitucionCOMENTARIOS(int cod);

}
