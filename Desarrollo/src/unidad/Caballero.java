package unidad;

/**
 * Clase que administra a la unidad del caballero.
 * <p>
 * Utiliza un caballo que al 3er ataque se pone rebelde. <br>
 * El caballo se puede calmar utilizando una poción de agua. <br>
 */
public class Caballero extends Unidad implements PocionDeAgua {
	/**
	 * Puntos de vida del caballero. <br>
	 */
	private static final double VIDA = 200;
	/**
	 * Ataque del caballero. <br>
	 */
	private static final int ATAQUE = 50;
	/**
	 * Caballo del caballero. <br>
	 */
	private boolean caballoRebelde;
	/**
	 * Cantidad de ataques realizados por el caballero. <br>
	 */
	private int cantidadAtaques;

	/**
	 * Crea un caballero. <br>
	 *
	 * @param posicion
	 *            Posición del caballero. <br>
	 */
	public Caballero(final int posicion) {
		super(ATAQUE, VIDA, posicion);
		this.caballoRebelde = false;
		this.cantidadAtaques = 0;
	}

	/**
	 * Utiliza la poción de agua para calmar al caballo. <br>
	 */
	@Override
	public void usarPocionDeAgua() {
		this.caballoRebelde = false;
		this.cantidadAtaques = 0;
	}

	public boolean puedeAtacar(final Unidad atacado) {
		if (!this.caballoRebelde && distanciaValida(atacado.getPosicion()) && atacado.isVivo()) {
			return true;
		}
		return false;
	}

	@Override
	public double getDaño() {
		this.cantidadAtaques++;
		if (this.cantidadAtaques == 3) {
			this.caballoRebelde = true;
		}
		return ATAQUE;
	}

	public boolean distanciaValida(final int posicion) {
		int diferencia = Math.abs(super.getPosicion() - posicion);
		if (diferencia >= 1 && diferencia <= 2) {
			return true;
		}
		return false;
	}
}
