package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import decorados.UnidadConPuñal;
import unidad.Arquero;
import unidad.Caballero;
import unidad.Lancero;
import unidad.Soldado;
import unidad.Unidad;

public class TestUnidadConPuñal {

	private Unidad soldadoPuñal;
	private Unidad caballeroPuñal;
	private Unidad lanceroPuñal;
	private Unidad arqueroPuñal;

	@Before
	public void iniciar() {
		this.soldadoPuñal = new UnidadConPuñal(new Soldado());
		this.caballeroPuñal = new UnidadConPuñal(new Caballero(0));
		this.arqueroPuñal = new UnidadConPuñal(new Arquero(0));
		this.lanceroPuñal = new UnidadConPuñal(new Lancero(0));
	}

	@Test
	public void testeandoAtributos() {
		assertEquals(200, caballeroPuñal.getSalud(), 0);
		assertTrue(caballeroPuñal.isVivo());

		assertEquals(150, lanceroPuñal.getSalud(), 0);
		assertTrue(lanceroPuñal.isVivo());

		assertEquals(50, arqueroPuñal.getSalud(), 0);
		assertTrue(arqueroPuñal.isVivo());
	}

	@Test
	public void testeandoDaño() {
		assertEquals(200, caballeroPuñal.getSalud(), 0);
		assertTrue(arqueroPuñal.atacar(caballeroPuñal));
		assertEquals(189, caballeroPuñal.getSalud(), 0);

		assertEquals(50, arqueroPuñal.getSalud(), 0);
		assertTrue(caballeroPuñal.atacar(arqueroPuñal));
		assertFalse(arqueroPuñal.isVivo());
		assertFalse(arqueroPuñal.atacar(caballeroPuñal));

		assertEquals(200, soldadoPuñal.getSalud(), 0);
		assertTrue(lanceroPuñal.atacar(soldadoPuñal));
		assertEquals(169, soldadoPuñal.getSalud(), 0);

		assertEquals(150, lanceroPuñal.getSalud(), 0);
		assertTrue(soldadoPuñal.atacar(lanceroPuñal));
		assertEquals(134, lanceroPuñal.getSalud(), 0);
	}
}
