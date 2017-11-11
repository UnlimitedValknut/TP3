package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import TP3.Arquero;
import TP3.Caballero;
import TP3.Lancero;
import TP3.Soldado;
import TP3.Unidad;
import TP3.UnidadConPunial;

public class UnidadConPuñal {

	Unidad soldadoPuñal;
	Unidad caballeroPuñal;
	Unidad lanceroPuñal;
	Unidad arqueroPuñal;

	@Before
	public void setUp() {
		soldadoPuñal = new UnidadConPunial(new Soldado());
		caballeroPuñal = new UnidadConPunial(new Caballero(1, 0));
		arqueroPuñal = new UnidadConPunial(new Arquero(2, 0));
		lanceroPuñal = new UnidadConPunial(new Lancero(1, 0));
	}

	/**
	 * Vemos si los atributos de cada rama estan bien ubicados
	 */
	@Test
	public void testeandoAtributos() {

		Assert.assertEquals(200, soldadoPuñal.getSalud(), 0);
		Assert.assertEquals(true, soldadoPuñal.estaVivo());
		Assert.assertEquals(100, ((UnidadConPunial) soldadoPuñal).getEnergia());

		Assert.assertEquals(200, caballeroPuñal.getSalud(), 0);
		Assert.assertEquals(true, caballeroPuñal.estaVivo());

		Assert.assertEquals(150, lanceroPuñal.getSalud(), 0);
		Assert.assertEquals(true, lanceroPuñal.estaVivo());

		Assert.assertEquals(50, arqueroPuñal.getSalud(), 0);
		Assert.assertEquals(true, arqueroPuñal.estaVivo());
	}

	/**
	 * Vemos si el daño esta bien aplicado
	 */
	@Test
	public void testeandoDanio() {
		Assert.assertEquals(200, caballeroPuñal.getSalud(), 0);
	    Assert.assertEquals(true, arqueroPuñal.atacar(caballeroPuñal));
		Assert.assertEquals(192, caballeroPuñal.getSalud(), 0);
		
		Assert.assertEquals(50, arqueroPuñal.getSalud(), 0);
		Assert.assertEquals(true, caballeroPuñal.atacar(arqueroPuñal));
		Assert.assertEquals(false, arqueroPuñal.estaVivo());
		Assert.assertEquals(false, arqueroPuñal.atacar(caballeroPuñal)); //arquero no puede atacar porque esta muerto

		Assert.assertEquals(200, soldadoPuñal.getSalud(), 0);
		Assert.assertEquals(true, lanceroPuñal.atacar(soldadoPuñal));
		Assert.assertEquals(172, soldadoPuñal.getSalud(), 0);

		Assert.assertEquals(150, lanceroPuñal.getSalud(), 0);
		Assert.assertEquals(true, soldadoPuñal.atacar(lanceroPuñal));
		Assert.assertEquals(137, lanceroPuñal.getSalud(), 0);

	}

}
