package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import decorados.UnidadConEscudo;
import unidad.Arquero;
import unidad.Caballero;
import unidad.Lancero;
import unidad.Soldado;
import unidad.Unidad;

public class UnidadConEscudoTest {

	private Unidad soldadoEscudo;
	private Unidad caballeroEscudo;
	private Unidad lanceroEscudo;
	private Unidad arqueroEscudo;

	@Before
	public void iniciar() {
		soldadoEscudo = new UnidadConEscudo(new Soldado());
		caballeroEscudo = new UnidadConEscudo(new Caballero(1));
		arqueroEscudo = new UnidadConEscudo(new Arquero(2));
		lanceroEscudo = new UnidadConEscudo(new Lancero(1));
	}

	@Test
	public void testeandoAtributos() {
		assertEquals(200, caballeroEscudo.getSalud(), 0);
		assertTrue(caballeroEscudo.isVivo());

		assertEquals(150, lanceroEscudo.getSalud(), 0);
		assertTrue(lanceroEscudo.isVivo());

		assertEquals(50, arqueroEscudo.getSalud(), 0);
		assertTrue(arqueroEscudo.isVivo());
	}

	@Test
	public void testeandoDaño() {
		assertEquals(50, arqueroEscudo.getSalud(), 0);
		assertTrue(caballeroEscudo.atacar(arqueroEscudo));
		assertEquals(30, arqueroEscudo.getSalud(), 0);

		assertEquals(200, caballeroEscudo.getSalud(), 0);
		assertTrue(arqueroEscudo.atacar(caballeroEscudo));
		assertEquals(198, caballeroEscudo.getSalud(), 0);

		assertEquals(200, soldadoEscudo.getSalud(), 0);
		assertTrue(lanceroEscudo.atacar(soldadoEscudo));
		assertEquals(190, soldadoEscudo.getSalud(), 0);

		assertEquals(150, lanceroEscudo.getSalud(), 0);
		assertTrue(soldadoEscudo.atacar(lanceroEscudo));
		assertEquals(146, lanceroEscudo.getSalud(), 0);
	}
}
