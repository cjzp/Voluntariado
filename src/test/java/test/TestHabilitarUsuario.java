package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.MySqlUsuarioDAO;

public class TestHabilitarUsuario {
	
	MySqlUsuarioDAO usuariodao = new MySqlUsuarioDAO();
	
	public void testtest()
	{
		assertTrue(true);
	}
	
	/*

	@Test
	public void deshabilitarUsuario() {
		
		String codigo ="i201514763";
		
		usuariodao.habilitarUsuario(codigo, false);
		
		assertTrue(usuariodao.buscarCodigoUsuario(codigo).getEstado()==11);
	}
	
	@Test
	public void habilitarUsuario() {
		
		String codigo ="i201514763";
		usuariodao.habilitarUsuario(codigo, true);
		
		assertTrue(usuariodao.buscarCodigoUsuario(codigo).getEstado()==10);
		assertTrue(true);
	}
*/
}
