package unidad;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import inventario.Capa;
import inventario.Escudo;
import inventario.Puñal;

public class TestUnidad {

	@Test
	public void testUnidades() {
		Unidad soldado = new Soldado(3);
		Arquero arquero = new Arquero(6);
		soldado.atacar(arquero);
		// El guerrero no podría atacarlo por la distancia.
		assertEquals(50, arquero.getSalud(), 0);
		arquero.atacar(soldado);
		// El arquero logra atacar al guerero.
		assertEquals(195, soldado.getSalud(), 0);
	}

	@Test
	public void testItems() {
		Lancero lancero = new Lancero(3);
		Soldado soldado = new Soldado(2);
		Caballero caballero = new Caballero(1);

		lancero.agregarItem(new Escudo());
		soldado.agregarItem(new Capa());
		soldado.agregarItem(new Puñal());

		lancero.atacar(soldado);
		// EL soldado perdio defensa por el puñal.
		assertEquals(172, soldado.getSalud(), 0);

		for (int i = 0; i < 10; i++) {
			soldado.atacar(caballero);
		}
		// Gracias a los modificadores de daño, el soldado logró sacarle 110.
		assertEquals(90, caballero.getSalud(), 0);
		soldado.atacar(caballero);
		// El soldado logra atacar una vez más permitida gracias a la capa.
		assertEquals(79, caballero.getSalud(), 0);

		// Gracias al escudo, logra reducir el ataque aumentado del soldado.
		soldado.atacar(lancero);
		assertEquals(143, lancero.getSalud(), 0);
	}

	@Test
	public void pocionesDeAgua() {
		Soldado soldado = new Soldado(3);
		Caballero caballero = new Caballero(4);
		int i = 0;
		while (i < 3) {
			soldado.atacar(caballero);
			caballero.atacar(soldado);
			i++;
		}

		// El caballero logró casi acabar con el guerero.
		assertEquals(50, soldado.getSalud(), 0);
		// El caballero logró casi acabar con el guerero.
		assertEquals(170, caballero.getSalud(), 0);
		soldado.atacar(caballero);
		caballero.atacar(soldado);

		// El soldado logra atacar al caballero, pero el caballero tiene al
		// caballo rebelde.
		assertEquals(50, soldado.getSalud(), 0);
		assertEquals(160, caballero.getSalud(), 0);

		// Hago que se le acabe la energía al soldado.
		for (int j = 0; j < 7; j++) {
			soldado.atacar(caballero);
		}
		soldado.atacar(caballero);
		// El soldado no tiene más energía para atacar.
		assertEquals(50, soldado.getSalud(), 0);
		assertEquals(100, caballero.getSalud(), 0);

		// Se restaura todo.
		soldado.usarPocionDeAgua();
		caballero.usarPocionDeAgua();

		// El soldado ataca y el caballero finalmente lo mata.
		soldado.atacar(caballero);
		assertEquals(90, caballero.getSalud(), 0);
		caballero.atacar(soldado);
		assertEquals(0, soldado.getSalud(), 0);
	}
}