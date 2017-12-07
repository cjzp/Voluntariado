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
		insti.setNombre("prueba");
		
		
		
		fail("Not yet implemented");
	}

}
