package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.MySqlInstitucionDAO;
import beans.InstitucionDTO;

public class TestInstitucion {

	MySqlInstitucionDAO dao = new MySqlInstitucionDAO();
	
	@Test
	public void test() {
		
		InstitucionDTO insti = new InstitucionDTO();
		insti.setCodigo(1005); //?
		insti.setNombre("prueba");
		insti.setCaracteristicas("caracteristicas de prueba");
		insti.setDireccion("direccion de prueba");
		insti.setComentarios("");
		insti.setTelefono("telefono de prueba");
		insti.setCalificacion(1);

		
		dao.registrarInstitucion(insti);
		
		InstitucionDTO recu = dao.buscarInstitucion(insti.getCodigo());
		dao.eliminarInstitucion(insti.getCodigo());
		
			
		assertTrue(insti.toString().equals(recu.toString()));
		
	}

}
