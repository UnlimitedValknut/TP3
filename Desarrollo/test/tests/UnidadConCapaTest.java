package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import decorados.UnidadConCapa;
import unidad.Arquero;
import unidad.Caballero;
import unidad.Lancero;
import unidad.Soldado;
import unidad.Unidad;

public class UnidadConCapaTest {

	private Unidad caballeroCapa;
	private Unidad lanceroCapa;
	private Unidad arqueroCapa;
	private Unidad soldadoCapa;

	@Before
	public void iniciar() {
		soldadoCapa = new UnidadConCapa(new Soldado(10));
		caballeroCapa = new UnidadConCapa(new Caballero(1));
		arqueroCapa = new UnidadConCapa(new Arquero(2));
		lanceroCapa = new UnidadConCapa(new Lancero(1));
	}

	@Test
	public void testEnergia() {
		Unidad dummy = new Soldado(1);
		int cant = 0;
		while (!dummy.isVivo()) {
			cant++;
		}
		assertEquals(0, cant, 0);
	}

	@Test
	public void testDaño() {
		assertEquals(200, caballeroCapa.getSalud(), 0);
		assertTrue(arqueroCapa.atacar(caballeroCapa));
		assertEquals(195.2, caballeroCapa.getSalud(), 0);

		assertEquals(50, arqueroCapa.getSalud(), 0);
		assertTrue(caballeroCapa.atacar(arqueroCapa));
		assertEquals(0.2, arqueroCapa.getSalud(), 0.01);

		assertEquals(200, soldadoCapa.getSalud(), 0);
		assertTrue(lanceroCapa.atacar(soldadoCapa));
		assertEquals(175.2, soldadoCapa.getSalud(), 0);

		assertEquals(150, lanceroCapa.getSalud(), 0);
		assertTrue(soldadoCapa.atacar(lanceroCapa));
		assertEquals(140.2, lanceroCapa.getSalud(), 0);
	}
}
