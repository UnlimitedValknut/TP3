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
	private static final double ATAQUE = 50;
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
		super(posicion, VIDA, ATAQUE);
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

	@Override
	public void atacar(final Unidad atacado) {
		if (!this.caballoRebelde && distanciaValida(atacado.getPosicion()) && atacado.isVivo()) {
			atacado.serAtacado(super.getDaño());
			this.cantidadAtaques++;
			if (this.cantidadAtaques == 3) {
				this.caballoRebelde = true;
			}
		}
	}

	@Override
	public boolean distanciaValida(final int posicion) {
		int diferencia = Math.abs(super.getPosicion() - posicion);
		if (diferencia >= 1 && diferencia <= 2) {
			return true;
		}
		return false;
	}
}