package service;

import java.util.List;
import beans.ComentariosDTO;
import beans.InstitucionDTO;
import beans.InstitucionNombresDTO;
import beans.ReporteComentCalificacionDTO;
import dao.DAOFactory;
import interfaces.InstitucionDAO;

public class InstitucionService 
{
	DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	InstitucionDAO objIns = fabrica.getInstitucion();
	
	
	public List<ReporteComentCalificacionDTO> listarComentariosCaliInstitucion()
	{
		return objIns.listarComentariosCalificacion();
	}
	public int registraComentarios(ComentariosDTO obj)
	{
		return objIns.registrarComentariosInstitucion(obj);
	}
	public List<InstitucionNombresDTO> listaInstitucionNombre()
	{
		return objIns.listarInstitucionNombres();
	}

	public ComentariosDTO buscaInstitucionParaCalificar(int cod)
	{
		return objIns.buscarInstitucionCOMENTARIOS(cod);
	}
	
	
	
	
	
	public List<InstitucionDTO> listaInstitucion()
	{
		return objIns.listarInstituciones();
	}
	
	public InstitucionDTO buscaInstitucion(int cod)
	{
		return objIns.buscarInstitucion(cod);
	}
	
	public int registraInstitucion(InstitucionDTO obj)
	{
		return objIns.registrarInstitucion(obj);
	}
	
	public int actualizaInstitucion(InstitucionDTO obj)
	{
		return objIns.actualizarInstitucion(obj);
	}
	
	public int EliminaInstitucion(int cod) 
	{
		return objIns.eliminarInstitucion(cod);
	}
}
