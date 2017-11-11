package unidad;

public class Soldado extends Unidad implements PocionDeAgua {
	/**
	 * Puntos de vida del soldado. <br>
	 */
	private static final double VIDA = 200;
	/**
	 * Ataque del soldado. <br>
	 */
	private static final int ATAQUE = 10;
	/**
	 * Energía máxima del soldado. <br>
	 */
	private static final double MAXIMO_ENERGIA = 100;
	/**
	 * Energía mínima necesaria para realizar un ataque. <br>
	 */
	private static final int ENERGIA_MINIMA_ATAQUE = 10;
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
		super(ATAQUE, VIDA, posicion);
		this.energia = MAXIMO_ENERGIA;
	}

	/**
	 * Restaura la energía al máximo del soldado. <br>
	 */
	public void usarPocionDeAgua() {
		this.energia = MAXIMO_ENERGIA;
	}

	public boolean puedeAtacar(final Unidad atacado) {
		if (this.energia >= ENERGIA_MINIMA_ATAQUE && distanciaValida(atacado.getPosicion()) && atacado.isVivo()) {
			return true;
		}
		return false;
	}

	@Override
	public double getDaño() {
		this.energia -= ENERGIA_MINIMA_ATAQUE;
		return ATAQUE;
	}

	public boolean distanciaValida(final int posicion) {
		if (Math.abs(super.getPosicion() - posicion) <= 1) {
			return true;
		}
		return false;
	}
}
