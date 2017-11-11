package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import TP3.Arquero;
import TP3.Caballero;
import TP3.Lancero;
import TP3.Soldado;
import TP3.Unidad;
import TP3.UnidadConCapa;

public class UnidadConCapaTest {

	Unidad soldadoCapa;
	Unidad caballeroCapa;
	Unidad lanceroCapa;
	Unidad arqueroCapa;
	
	@Before
	public void setUp() {
	soldadoCapa = new UnidadConCapa(new Soldado());
	caballeroCapa = new UnidadConCapa(new Caballero(1,0));
	arqueroCapa = new UnidadConCapa(new Arquero(2,0));
	lanceroCapa = new UnidadConCapa(new Lancero(1,0));
	}
	
	/**
	 * Vemos si los atributos de cada rama estan bien ubicados
	 */
	@Test
	public void testeandoAtributos() {

		Assert.assertEquals(200, soldadoCapa.getSalud(),0);
		Assert.assertEquals(true, soldadoCapa.estaVivo());

		Assert.assertEquals(200, caballeroCapa.getSalud(),0);
		Assert.assertEquals(true, caballeroCapa.estaVivo());

		Assert.assertEquals(150, lanceroCapa.getSalud(),0);
		Assert.assertEquals(true, lanceroCapa.estaVivo());

		Assert.assertEquals(50, arqueroCapa.getSalud(),0);
		Assert.assertEquals(true, arqueroCapa.estaVivo());
	}
	
	/**
	 * Vemos si el daño esta bien aplicado
	 */
	@Test
	public void testeandoEnergia() {
		Unidad domie = new Soldado(1,0);
		int cant = 0;
		
		while(soldadoCapa.atacar(domie))
			cant++;
		
		Assert.assertEquals(20, cant, 0);
		
	}
	
	/**
	 * Vemos si el daño esta bien aplicado
	 */
	@Test
	public void testeandoDanio() {
		
		Assert.assertEquals(200, caballeroCapa.getSalud(),0);
		Assert.assertEquals(true, arqueroCapa.atacar(caballeroCapa));
		Assert.assertEquals(195.5, caballeroCapa.getSalud(),0);
		
		Assert.assertEquals(50, arqueroCapa.getSalud(),0);
		Assert.assertEquals(true, caballeroCapa.atacar(arqueroCapa));
		Assert.assertEquals(5, arqueroCapa.getSalud(),0);
		

		Assert.assertEquals(200, soldadoCapa.getSalud(),0);
		Assert.assertEquals(true, lanceroCapa.atacar(soldadoCapa));
		Assert.assertEquals(177.5, soldadoCapa.getSalud(),0);
		
		Assert.assertEquals(150, lanceroCapa.getSalud(),0);
		Assert.assertEquals(true, soldadoCapa.atacar(lanceroCapa));
		Assert.assertEquals(141, lanceroCapa.getSalud(),0);
		
	}

}
