package test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import beans.ActividadDTO;
import dao.MySqlActividadDAO;


public class TestActividad {

	MySqlActividadDAO dao = new MySqlActividadDAO();
	
	@Test
	public void testRegistraBusca() {
		
		
		
		ActividadDTO act = new ActividadDTO();
		act.setCodigo(2); //debe haber una ya registrada
		act.setCod_institucion(1);
		act.setNombre("prueba");
		act.setDescripcion("descripcion de prueba");
		
		java.util.Date ftemp=null;
		try {
			ftemp = new SimpleDateFormat("yyyy-MM-dd").parse("2000-10-10");
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		Date sqlDate= new Date(ftemp.getTime());		
		act.setFecha(sqlDate);
		
		act.setHoraInicio("10:00");
		act.setHoraFin("12:00");
		act.setCod_docente("pmvelasco");
		act.setCodEstado(1); // 1 activo 3 inactivo 2 espera
		act.setMotivoEstado("");
		act.setVacantesMax(10);
		act.setVacantesMin(5);
					
		ActividadDTO recu = new ActividadDTO();
		
		dao.registrarActividad(act);
		recu = dao.buscarActividad(act.getCodigo());
		dao.eliminarActividad(act.getCodigo());
		
			
		assertTrue(recu.toString().equals(act.toString()));
		
		
	}

}
