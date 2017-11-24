package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import unidad.Soldado;

public class SoldadoTest {

	private Soldado ryan;
	private Soldado bubba;
	private Soldado dan;

	@Before
	public void iniciar() {
		ryan = new Soldado();
		bubba = new Soldado(1);
		dan = new Soldado(2);
	}

	@Test
	public void testAtributos() {
		assertEquals(200, ryan.getSalud(), 0);
		assertEquals(100, ryan.getEnergia(), 0);
	}

	@Test
	public void testLimitesEnergia() {
		int cant = 0;
		while (ryan.atacar(bubba)) {
			cant++;
		}
		assertEquals(0, ryan.getEnergia(), 0);
		assertEquals(10, cant, 0);
		assertFalse(ryan.atacar(bubba));
	}

	@Test
	public void testAtacar() {
		assertTrue(ryan.atacar(bubba));
		assertEquals(190, bubba.getSalud(), 0);
		assertEquals(90, ryan.getEnergia(), 0);
	}

	@Test
	public void testDistancias() {

		assertTrue(ryan.atacar(bubba));
		assertTrue(bubba.atacar(ryan));

		assertFalse(dan.atacar(ryan));
		assertFalse(ryan.atacar(dan));

		assertTrue(dan.atacar(bubba));
		assertTrue(bubba.atacar(dan));
	}

	@Test
	public void testRecibirDaño() {
		assertTrue(bubba.atacar(ryan));
		assertEquals(190, ryan.getSalud(), 0);
	}

	@Test
	public void testPocionDeAgua() {
		int cant = 0;
		while (ryan.atacar(bubba)) {
			cant++;
		}
		assertEquals(0, ryan.getEnergia(), 0);
		assertEquals(10, cant, 0);
		assertFalse(ryan.atacar(bubba));

		ryan.usarPocionDeAgua();
		Assert.assertEquals(100, ryan.getEnergia(), 0);
	}

	@Test
	public void testMorir() {
		for (int i = 0; i < 10; i++) {
			assertTrue(ryan.isVivo());
			bubba.atacar(ryan);
		}
		bubba.usarPocionDeAgua();

		for (int i = 0; i < 10; i++) {
			Assert.assertEquals(true, ryan.isVivo());
			bubba.atacar(ryan);
		}
		assertFalse(ryan.isVivo());
	}

	@Test
	public void testZombie() {
		for (int i = 0; i < 10; i++) {
			bubba.atacar(ryan);
		}
		bubba.usarPocionDeAgua();

		for (int i = 0; i < 10; i++) {
			bubba.atacar(ryan);
		}
		assertFalse(ryan.isVivo());
		assertFalse(ryan.atacar(bubba));
	}
}
