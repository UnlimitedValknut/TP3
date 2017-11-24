package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import unidad.Caballero;

public class CaballeroTest {

	private Caballero mike;
	private Caballero george;
	private Caballero lancelot;

	@Before
	public void iniciar() {
		mike = new Caballero();
		george = new Caballero(1);
		lancelot = new Caballero(3);
	}

	@Test
	public void testAtributos() {
		assertEquals(200, mike.getSalud(), 0);
		assertTrue(mike.isVivo());
	}

	@Test
	public void testDaño() {
		mike.atacar(george);
		assertEquals(150, george.getSalud(), 0);
		george.atacar(mike);
		assertEquals(150, mike.getSalud(), 0);
		assertTrue(mike.isVivo() && george.isVivo());
	}

	@Test
	public void testMuerte() {
		while (george.isVivo()) {
			mike.atacar(george);
			mike.usarPocionDeAgua();
		}
		assertEquals(0, george.getSalud(), 0);
		assertFalse(george.isVivo());
	}

	@Test
	public void testZombie() {
		while (mike.isVivo()) {
			george.atacar(mike);
			george.usarPocionDeAgua();
		}
		assertFalse(mike.isVivo());
		assertFalse(mike.atacar(george));
	}

	@Test
	public void testDistancia() {
		assertTrue(mike.atacar(george));
		assertTrue(george.atacar(mike));

		assertFalse(lancelot.atacar(mike));
		assertFalse(mike.atacar(lancelot));

		assertTrue(george.atacar(lancelot));
		assertTrue(lancelot.atacar(george));
	}

	@Test
	public void testCaballoRebelde() {
		for (int i = 0; i < 5; i++) {
			mike.atacar(george);
		}
		assertFalse(mike.atacar(george));
	}

	@Test
	public void testPocionDeAgua() {
		for (int i = 0; i < 5; i++) {
			george.atacar(mike);
		}
		assertFalse(george.atacar(mike));
		george.usarPocionDeAgua();
		assertTrue(george.atacar(mike));
	}
}
