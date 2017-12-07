package test;

import static org.junit.Assert.*;
import org.junit.Test;

import beans.AlumnoDTO;
import beans.UsuarioDTO;
import dao.MySqlAlumnoDAO;
import dao.MySqlUsuarioDAO;

public class TestAnotarActividad {

	MySqlAlumnoDAO dao = new MySqlAlumnoDAO();
	MySqlUsuarioDAO daoUsu = new MySqlUsuarioDAO();
	
	@Test
	public void testAnotar() {
		
		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setApellido("testapellido");
		usuario.setCodigo("test01");
		usuario.setCorreo("test@test.com");
		usuario.setEstado(10); //10 activo 11 inactivo
		usuario.setLogin("usertest");
		usuario.setNombre("testnombre");
		usuario.setPassword("passtest");
		usuario.setTelefono("0800-STAR-WARS");
		
		
		daoUsu.insertarUsuario(usuario);
				
		AlumnoDTO alumno = new AlumnoDTO();
		alumno.setCarrera(1);
		alumno.setSeccion(1);
		alumno.setCod_actividad(0); // aun no anotado
		alumno.setCodigo_usuario("test01");
		alumno.setCodigo("test01");
		
		
		dao.insertarAlumno(alumno);
		
		int codigoAct = 1;
		
		
		dao.anotarActividad(alumno.getCodigo(), codigoAct);
		
		AlumnoDTO recu = dao.buscarCodigoAlumno(alumno.getCodigo());
		dao.eliminarAlumno(alumno.getCodigo());
		
		assertTrue(recu.getCod_actividad()==codigoAct);
		
	}

}
