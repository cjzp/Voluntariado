package dao;


import interfaces.UsuarioDAO;
import interfaces.ActividadDAO;
import interfaces.AlumnoDAO;
import interfaces.DocenteDAO;
import interfaces.InstitucionDAO;
import interfaces.VoluntariadoDAO;

public class MYSqlDAOFactory extends DAOFactory 
{
	@Override
	public InstitucionDAO getInstitucion() 
	{
		return new MySqlInstitucionDAO();
	}
	@Override
	public VoluntariadoDAO getVoluntariado() 
	{
		return new MySqlVoluntariadoDAO();
	}
	@Override
	public ActividadDAO getActividad() 
	{
		return new MySqlActividadDAO();
	}
	
	@Override
	public UsuarioDAO getUsuario() 
	{
		return new MySqlUsuarioDAO();
	}
	@Override
	public DocenteDAO getDocente() {
		
		return new MySqlDocenteDAO();
	}
	@Override
	public AlumnoDAO getAlumno() {
		
		return new MySqlAlumnoDAO();
	}
}
