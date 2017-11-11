package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import TP3.Arquero;
import TP3.Caballero;
import TP3.Lancero;
import TP3.Soldado;
import TP3.Unidad;
import TP3.UnidadConEscudo;

public class UnidadConEscudoTest {

	Unidad soldadoEscudo;
	Unidad caballeroEscudo;
	Unidad lanceroEscudo;
	Unidad arqueroEscudo;
	
	@Before
	public void setUp() {
	soldadoEscudo = new UnidadConEscudo(new Soldado());
	caballeroEscudo = new UnidadConEscudo(new Caballero(1,0));
	arqueroEscudo = new UnidadConEscudo(new Arquero(2,0));
	lanceroEscudo = new UnidadConEscudo(new Lancero(1,0));
	}
	
	/**
	 * Vemos si los atributos de cada rama estan bien ubicados
	 */
	@Test
	public void testeandoAtributos() {

		Assert.assertEquals(200, soldadoEscudo.getSalud(),0);
		Assert.assertEquals(true, soldadoEscudo.estaVivo());
		Assert.assertEquals(100, ((UnidadConEscudo)soldadoEscudo).getEnergia());
		
		Assert.assertEquals(200, caballeroEscudo.getSalud(),0);
		Assert.assertEquals(true, caballeroEscudo.estaVivo());

		Assert.assertEquals(150, lanceroEscudo.getSalud(),0);
		Assert.assertEquals(true, lanceroEscudo.estaVivo());

		Assert.assertEquals(50, arqueroEscudo.getSalud(),0);
		Assert.assertEquals(true, arqueroEscudo.estaVivo());
	}
	
	/**
	 * Vemos si el daño esta bien aplicado
	 */
	@Test
	public void testeandoDanio() {
		Assert.assertEquals(50, arqueroEscudo.getSalud(),0);
		Assert.assertEquals(true, caballeroEscudo.atacar(arqueroEscudo));
		Assert.assertEquals(30, arqueroEscudo.getSalud(),0);
		
		Assert.assertEquals(200, caballeroEscudo.getSalud(),0);
		Assert.assertEquals(true, arqueroEscudo.atacar(caballeroEscudo));
		Assert.assertEquals(198, caballeroEscudo.getSalud(),0);
		

		Assert.assertEquals(200, soldadoEscudo.getSalud(),0);
		Assert.assertEquals(true, lanceroEscudo.atacar(soldadoEscudo));
		Assert.assertEquals(190, soldadoEscudo.getSalud(),0);
		
		Assert.assertEquals(150, lanceroEscudo.getSalud(),0);
		Assert.assertEquals(true, soldadoEscudo.atacar(lanceroEscudo));
		Assert.assertEquals(146, lanceroEscudo.getSalud(),0);
		
	}

}
