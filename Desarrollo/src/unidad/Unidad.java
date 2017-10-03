package unidad;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import inventario.Item;

/**
 * Clase que administra las distintas unidades. <br>
 */
public abstract class Unidad implements Combate {
	/**
	 * Posición de la unidad en el mapa. <br>
	 */
	private int posicion;
	/**
	 * Puntos de salud de la unidad. <br>
	 */
	private double salud;
	/**
	 * Daño que realiza la unidad. <br>
	 */
	private double daño;
	/**
	 * Inventario de la unidad. <br>
	 */
	private List<Item> inventario = new LinkedList<Item>();

	/**
	 * Crea una unidad con su posición, sus puntos de salud y el daño que
	 * realiza. <br>
	 * 
	 * @param posicion
	 *            Posición de la unidad en el mapa. <br>
	 * @param salud
	 *            Puntos de salud de la unidad. <br>
	 * @param daño
	 *            Puntos de daño de la unidad. <br>
	 */
	public Unidad(final int posicion, final double salud, final double daño) {
		this.posicion = posicion;
		this.daño = daño;
		this.salud = salud;
	}

	/**
	 * Agrega un item al inventario. <br>
	 * 
	 * @param item
	 *            Item a agregar. <br>
	 */
	public void agregarItem(final Item item) {
		inventario.add(item);
	}

	/**
	 * Devuelve la posición de la unidad. <br>
	 * 
	 * @return Posición de la unidad. <br>
	 */
	public int getPosicion() {
		return this.posicion;
	}

	/**
	 * Devuelve los puntos de salud de la unidad. <br>
	 * 
	 * @return Puntos de salud de la unidad. <br>
	 */
	public double getSalud() {
		return this.salud;
	}

	/**
	 * Obtiene el daño que genera la unidad.
	 * <p>
	 * Tiene en cuenta los items equipados. <br>
	 * 
	 * @return Daño realizado. <br>
	 */
	public double getDaño() {
		int sumaDaño = 0;
		int multiplicadorDaño = 0;
		for (ListIterator<Item> iterator = this.inventario.listIterator(); iterator.hasNext();) {
			Item actual = iterator.next();
			sumaDaño += actual.getSumaAtaque();
			multiplicadorDaño += this.daño * actual.getMultiplicadorAtaque();
		}
		return this.daño + multiplicadorDaño + sumaDaño;
	}

	@Override
	public void serAtacado(final double daño) {
		int sumaDefensa = 0;
		int multiplicadorDefensa = 0;
		for (ListIterator<Item> iterator = this.inventario.listIterator(); iterator.hasNext();) {
			Item actual = iterator.next();
			sumaDefensa += actual.getSumaDefensa();
			multiplicadorDefensa += daño * actual.getMultiplicadorDefensa();
		}
		if (daño >= (multiplicadorDefensa + sumaDefensa)) {
			this.salud -= daño + multiplicadorDefensa + sumaDefensa;
		}
		if (this.salud < 0) {
			this.salud = 0;
		}
	}

	/**
	 * Permite a la unidad cambiar su posición en el campo de batalla. <br>
	 * 
	 * @param posicionNueva
	 *            Nueva posición de la unidad. <br>
	 */
	public void cambiarPosicion(final int posicionNueva) {
		this.posicion = posicionNueva;
	}
}