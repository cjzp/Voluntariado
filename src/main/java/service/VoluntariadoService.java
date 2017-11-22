package service;

import java.util.List;

import beans.VoluntariadoDTO;
import dao.DAOFactory;
import interfaces.VoluntariadoDAO;

public class VoluntariadoService 
{
	DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	VoluntariadoDAO objVol = fabrica.getVoluntariado();
	
	public List<VoluntariadoDTO> listaVoluntariado()
	{
		return objVol.listarVoluntarios();
	}
	
	public VoluntariadoDTO buscaVoluntariado(int cod)
	{
		return objVol.buscarVoluntariado(cod);
	}
	
	public int registraVoluntariado(VoluntariadoDTO obj)
	{
		return objVol.registrarVoluntariado(obj);
	}
	
	public int actualizaVoluntariado(VoluntariadoDTO obj)
	{
		return objVol.actualizarVoluntariado(obj);
	}
	
	public int EliminaVoluntariado(int cod) 
	{
		return objVol.eliminarVoluntariado(cod);
	}
	
	public List<VoluntariadoDTO> buscarPorActividad(String nombreActividad)
	{
		return objVol.buscarPorActividad(nombreActividad);
	}
	
	public List<VoluntariadoDTO> buscarPorAlumno(String codigoAlumno)
	{
		return objVol.buscarPorAlumno(codigoAlumno);
	}
	public List<VoluntariadoDTO> buscarPorSeccion(String seccion)
	{
		return objVol.buscarPorSeccion(seccion);
	}
	public List<VoluntariadoDTO> controlDeAlumno(String codigoAlumno)
	{
		return objVol.controlDeAlumno(codigoAlumno);
	}
	public List<VoluntariadoDTO> buscarHorasAlumno(String codigoAlumno)
	{
		return objVol.buscarHorasAlumno(codigoAlumno);
	}
}
