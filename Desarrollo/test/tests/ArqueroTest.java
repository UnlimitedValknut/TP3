package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import unidad.Arquero;

public class ArqueroTest {

	private Arquero leo;
	private Arquero lucas;
	private Arquero guido;

	@Before
	public void inciar() {
		leo = new Arquero();
		lucas = new Arquero(3);
		guido = new Arquero(5);
	}

	@Test
	public void testAtributos() {
		assertEquals(50, leo.getSalud(), 0);
		assertEquals(true, leo.isVivo());
	}

	@Test
	public void testLimiteDeFlechas() {
		int cant = 0;
		while (leo.atacar(lucas)) {
			cant++;
		}
		assertEquals(10, cant, 0);
	}

	@Test
	public void testCargarFlechas() {
		int cant = 0;
		while (leo.atacar(lucas)) {
			cant++;
		}
		assertEquals(10, cant);
		leo.recargarFlechas();
		while (leo.atacar(guido)) {
			cant++;
		}
		assertEquals(20, cant, 0);
	}

	@Test
	public void testAtacar() {
		assertEquals(50, lucas.getSalud(), 0);
		leo.atacar(lucas);
		assertEquals(45, lucas.getSalud(), 0);
	}

	@Test
	public void testRecibirDaño() {
		assertEquals(50, leo.getSalud(), 0);
		lucas.atacar(leo);
		assertEquals(45, leo.getSalud(), 0);
	}

	@Test
	public void testSinFlechas() {
		int cant = 0;
		while (leo.atacar(lucas)) {
			cant++;
		}
		assertEquals(10, cant, 0);
		assertFalse(leo.atacar(lucas));
	}

	@Test
	public void testDistancias() {
		assertTrue(leo.atacar(lucas));
		assertTrue(lucas.atacar(leo));
		assertTrue(lucas.atacar(guido));
		assertTrue(guido.atacar(lucas));
		assertTrue(guido.atacar(leo));
		assertTrue(leo.atacar(guido));
	}

	@Test
	public void testMorir() {
		while (leo.isVivo()) {
			lucas.atacar(leo);
		}
		assertFalse(leo.isVivo());
	}

	@Test
	public void testZombie() {
		while (leo.isVivo()) {
			lucas.atacar(leo);
		}
		assertFalse(leo.isVivo());
		assertFalse(leo.atacar(lucas));
	}
}
