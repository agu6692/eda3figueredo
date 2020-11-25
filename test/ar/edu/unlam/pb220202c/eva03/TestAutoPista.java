package ar.edu.unlam.pb220202c.eva03;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestAutoPista {
	
	@Test
	public void queSePuedaRegistrarTelepase () {
		Autopista autopistaDelSol= new Autopista("sol");
		Vehiculo vwGol= new Automovil("po8",120, 130);
		Vehiculo scania= new Automovil("po8",70, 80);
		
		
		 assertTrue(autopistaDelSol.registrarTelepase(1234, vwGol));
	     assertTrue(autopistaDelSol.registrarTelepase(1235, scania));
		
		
	}
    @Test (expected = Exception.class)
	public void queAlSalirDelAutopistaNoestaEncirculacionLanceUnaExcepcion() throws Exception {
    	 Autopista sol = new Autopista("sol");
         Vehiculo vw = new Vehiculo("po7", 100, 130);
         assertTrue(sol.registrarTelepase(100, vw));
         assertTrue(sol.ingresarAutopista(150));
         sol.salirAutpista(vw);
	}
	@Test
	public void queVerifiqueQueSeObtengaUnaListaDeAutosInsfractoresOrdenadaPorPatente(){
		
	}
    @Test
	public void generetestAEleccion1() {
		
	}
	@Test
	public void generetestAEleccion2() {
		
	}
	
}
