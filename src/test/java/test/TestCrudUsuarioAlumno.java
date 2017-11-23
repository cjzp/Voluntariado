package test;
import static org.junit.Assert.*;

import org.junit.Test;


import beans.*;
import dao.*;
import service.AlumnoService;
import service.UsuarioService;

/*
 * ('1','Computacion e Informatica'),
	('2','Administracion y Sistemas'),
   ('3','Administracion de Empresas'),
   ('4','Contabilidad');

 ('1','TA01'),
 ('2','ASA01'),
 ('3','AEA01'),
 ('4','CA01')
 */
 

public class TestCrudUsuarioAlumno {
	
	//AlumnoService alumnoser = new AlumnoService();
	//UsuarioService usuarioser = new UsuarioService();
	
	MySqlAlumnoDAO alumnoser = new MySqlAlumnoDAO();
	MySqlUsuarioDAO usuarioser = new MySqlUsuarioDAO();
	
	
	@Test
	public void testInsertarUsuarioAlumno() {
		//fail("Not yet implemented");
		
		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setApellido("testapellido");
		usuario.setCodigo("test01");
		usuario.setCorreo("test@test.com");
		usuario.setEstado(10); //10 activo 11 inactivo
		usuario.setLogin("usertest");
		usuario.setNombre("testnombre");
		usuario.setPassword("passtest");
		usuario.setTelefono("0800-STAR-WARS");
		
		
		usuarioser.insertarUsuario(usuario);
				
		AlumnoDTO alumno = new AlumnoDTO();
		alumno.setCarrera(1);
		alumno.setSeccion(1);
		alumno.setCod_actividad(0); // aun no anotado
		alumno.setCodigo_usuario("test01");
		alumno.setCodigo("test01");
		
		
		alumnoser.insertarAlumno(alumno);
		
		
		AlumnoDTO AlumnoRecu = alumnoser.buscarCodigoAlumno("test01");
		
		assertTrue(AlumnoRecu.toString().equals(alumno.toString()));
	}
	
	
	@Test
	public void testUsuarioAlumnoInsertado() {
				
				
		AlumnoDTO alumno = new AlumnoDTO();
		alumno.setCarrera(1);
		alumno.setSeccion(1);
		alumno.setCod_actividad(0); // aun no anotado
		alumno.setCodigo_usuario("test01");
		alumno.setCodigo("test01");
		
		
	
		AlumnoDTO alumnoRecu = alumnoser.buscarCodigoAlumno("test01");
		
		
		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setApellido("testapellido");
		usuario.setCodigo("test01");
		usuario.setCorreo("test@test.com");
		usuario.setEstado(10); //10 activo 11 inactivo
		usuario.setLogin("usertest");
		usuario.setNombre("testnombre");
		usuario.setPassword("passtest");
		usuario.setTelefono("0800-STAR-WARS");
		
	
		UsuarioDTO usuarioRecu = usuarioser.buscarCodigoUsuario("test01");
	
		
		
		assertTrue(usuario.toString().equals(usuarioRecu.toString())
				&&
				alumno.toString().equals(alumnoRecu.toString())
				
				);
		
		
	}
	
	
	@Test
	public void testActualizarUsuarioAlumno()
	{
		AlumnoDTO alumno = new AlumnoDTO();
		alumno.setCarrera(2);
		alumno.setSeccion(2);
		alumno.setCod_actividad(0); // aun no anotado
		
		alumno.setCodigo_usuario("test01");
		alumno.setCodigo("test01");
		
		///////////////////////////
		
		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setApellido("2testapellido");
		usuario.setCodigo("test01");
		usuario.setCorreo("2test@test.com");
		usuario.setEstado(10); //10 activo 11 inactivo
		usuario.setLogin("usertest");
		usuario.setNombre("testnombre");
		usuario.setPassword("passtest");
		usuario.setTelefono("0800-STAR-WARS");
		
		usuarioser.actualizarUsuario(usuario);
		alumnoser.actualizarAlumno(alumno);
		
		UsuarioDTO usuarioRecu = usuarioser.buscarCodigoUsuario("test01");
		AlumnoDTO alumnoRecu = alumnoser.buscarCodigoAlumno("test01");
		
		assertTrue(
				usuario.toString().equals(usuarioRecu.toString())
				&&
				alumno.toString().equals(alumnoRecu.toString())
				);
		
		
		
		
	}
		
	
	@Test
	public void testEliminarUsuarioAlumno()
	{
		AlumnoDTO alumnoRecu; 
		UsuarioDTO usuarioRecu;
		
		
		usuarioser.eliminarUsuario("test01");
		alumnoser.eliminarAlumno("test01"); 
		
		 usuarioRecu = usuarioser.buscarCodigoUsuario("test01");
		 alumnoRecu = alumnoser.buscarCodigoAlumno("test01");
		
		
		
		assertTrue(
				alumnoRecu == null && usuarioRecu ==null 
				
				);
		
		
		
		
	}
	
	
	

	
	

}
