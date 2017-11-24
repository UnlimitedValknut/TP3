package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import unidad.Lancero;

public class LanceroTest {

	private Lancero lanzin;
	private Lancero lanuno;
	private Lancero mok;

	@Before
	public void inicar() {
		lanzin = new Lancero();
		lanuno = new Lancero(1);
		mok = new Lancero(4);
	}

	@Test
	public void testAtributos() {
		assertEquals(150, lanzin.getSalud(), 0);
		assertTrue(lanzin.isVivo());
	}

	@Test
	public void testDaño() {
		lanzin.atacar(lanuno);
		assertEquals(125, lanuno.getSalud(), 0);

		lanuno.atacar(lanzin);
		assertEquals(125, lanzin.getSalud(), 0);
	}

	@Test
	public void testAtacar() {
		assertTrue(lanzin.atacar(lanuno));
		Assert.assertEquals(125, lanuno.getSalud(), 0);
	}

	@Test
	public void testDistancias() {
		assertTrue(lanzin.atacar(lanuno));
		assertTrue(lanuno.atacar(lanzin));

		assertFalse(lanzin.atacar(mok));
		assertFalse(mok.atacar(lanzin));

		assertTrue(mok.atacar(lanuno));
		assertTrue(lanuno.atacar(mok));
	}

	@Test
	public void testMorir() {
		while (lanzin.isVivo()) {
			lanuno.atacar(lanzin);
		}
		assertFalse(lanzin.isVivo());
	}

	@Test
	public void testZombie() {
		while (lanzin.isVivo()) {
			lanuno.atacar(lanzin);
		}
		assertFalse(lanzin.atacar(lanuno));
	}
}
