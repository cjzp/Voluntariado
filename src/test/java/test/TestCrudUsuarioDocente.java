package test;

import static org.junit.Assert.*;

import org.junit.Test;

import beans.DocenteDTO;
import beans.UsuarioDTO;
import dao.MySqlDocenteDAO;
import dao.MySqlUsuarioDAO;

public class TestCrudUsuarioDocente {

	//AlumnoService alumnoser = new AlumnoService();
			//UsuarioService usuarioser = new UsuarioService();
			
			MySqlDocenteDAO docenteser = new MySqlDocenteDAO();
			MySqlUsuarioDAO usuarioser = new MySqlUsuarioDAO();
			
			public void testtest()
			{
				assertTrue(true);
			}
			
			
			

			
			@Test
			public void testInsertarUsuarioDocente() {
				//fail("Not yet implemented");
				
				UsuarioDTO usuario = new UsuarioDTO();
				usuario.setApellido("testapellidoDOC");
				usuario.setCodigo("tDOC01");
				usuario.setCorreo("test@testDOC.com");
				usuario.setEstado(10); //10 activo 11 inactivo
				usuario.setLogin("utestDOC");
				usuario.setNombre("testnombreDOC");
				usuario.setPassword("passtestDOC");
				usuario.setTelefono("0800-STAR-WARS-DOC");
				
		
				usuarioser.insertarUsuario(usuario);
						
				DocenteDTO docente= new DocenteDTO();
				docente.setCod_usuario("tDOC01");
				docente.setCodigo("tDOC01");
				
				
				docenteser.insertarDocente (docente);
				
				
				DocenteDTO DocenteRecu = docenteser.buscarCodigoDocente("tDOC01");
				
				assertTrue(DocenteRecu.toString().equals(docente.toString()));
			}
			
			
			@Test
			public void testUsuarioAlumnoInsertado() {
						
						
				DocenteDTO docente = new DocenteDTO();
				docente.setCod_usuario("tDOC01");
				docente.setCodigo("tDOC01");
				
						
				DocenteDTO docenteRecu = docenteser.buscarCodigoDocente("tDOC01");
				
				
				UsuarioDTO usuario = new UsuarioDTO();
				usuario.setApellido("testapellidoDOC");
				usuario.setCodigo("tDOC01");
				usuario.setCorreo("test@testDOC.com");
				usuario.setEstado(10); //10 activo 11 inactivo
				usuario.setLogin("utestDOC");
				usuario.setNombre("testnombreDOC");
				usuario.setPassword("passtestDOC");
				usuario.setTelefono("0800-STAR-WARS-DOC");
			
				UsuarioDTO usuarioRecu = usuarioser.buscarCodigoUsuario("tDOC01");
			
				
				
				assertTrue(usuario.toString().equals(usuarioRecu.toString())
						&&
						docente.toString().equals(docenteRecu.toString())
						
						);
				
				
			}
			
			
			@Test
			public void testActualizarUsuarioAlumno()
			{
				DocenteDTO docente= new DocenteDTO();
				
				docente.setCod_usuario("tDOC01");
				docente.setCodigo("tDOC01");
				
			
				
				///////////////////////////
				
				UsuarioDTO usuario = new UsuarioDTO();
				usuario.setApellido("apellidoCambio");
				usuario.setCodigo("tDOC01");
				usuario.setCorreo("test@testDOC.com");
				usuario.setEstado(10); //10 activo 11 inactivo
				usuario.setLogin("utestDOC");
				usuario.setNombre("testnombreDOC");
				usuario.setPassword("passCambio");
				usuario.setTelefono("0800-STAR-WARS-DOC");
				
				usuarioser.actualizarUsuario(usuario);
				docenteser.actualizarDocente(docente);
				
				UsuarioDTO usuarioRecu = usuarioser.buscarCodigoUsuario("tDOC01");
				DocenteDTO docenteRecu = docenteser.buscarCodigoDocente("tDOC01");
				
				assertTrue(
						usuario.toString().equals(usuarioRecu.toString())
						&&
						docente.toString().equals(docenteRecu.toString())
						);
				
				
				
				
			}
				
			
			@Test
			public void testEliminarUsuarioDocente()
			{
				DocenteDTO docenteRecu; 
				UsuarioDTO usuarioRecu;
				
				
				usuarioser.eliminarUsuario("tDOC01");
				docenteser.eliminarDocente("tDOC01"); 
				
				 usuarioRecu = usuarioser.buscarCodigoUsuario("tDOC01");
				 docenteRecu = docenteser.buscarCodigoDocente("tDOC01");
				
				
				
				assertTrue(
						docenteRecu == null && usuarioRecu ==null 
						
						);
				
				
				
			}

}
