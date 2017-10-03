package unidad;

import inventario.Item;

public class Soldado extends Unidad implements PocionDeAgua {
	/**
	 * Puntos de vida del soldado. <br>
	 */
	private static final double VIDA = 200;
	/**
	 * Ataque del soldado. <br>
	 */
	private static final double ATAQUE = 10;
	/**
	 * Energía máxima del soldado. <br>
	 */
	private static final double MAXIMOENERGIA = 100;
	/**
	 * Energía del soldado. <br>
	 */
	private double energia;

	/**
	 * Crea un soldado. <br>
	 * 
	 * @param posicion
	 *            Posición del soldado. <br>
	 */
	public Soldado(final int posicion) {
		super(posicion, VIDA, ATAQUE);
		this.energia = MAXIMOENERGIA;
	}

	/**
	 * Restaura la energía al máximo del soldado. <br>
	 */
	@Override
	public void usarPocionDeAgua() {
		this.energia = MAXIMOENERGIA;
	}

	@Override
	public void agregarItem(final Item item) {
		this.energia += (this.energia * item.getMultiplicadorEnergia());
		super.agregarItem(item);
	}

	@Override
	public void atacar(final Unidad atacado) {
		if (this.energia >= 10 && distanciaValida(atacado.getPosicion())) {
			atacado.serAtacado(super.getDaño());
			this.energia -= 10;
		}
	}

	@Override
	public boolean distanciaValida(final int posicion) {
		if (Math.abs(super.getPosicion() - posicion) <= 1) {
			return true;
		}
		return false;
	}
}