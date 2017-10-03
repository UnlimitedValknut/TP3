package unidad;

/**
 * Clase que administra a un lancero. <br>
 */
public class Lancero extends Unidad {
	/**
	 * Puntos de vida del lancer. <br>
	 */
	private static final double VIDA = 150;
	/**
	 * Ataque del lancero. <br>
	 */
	private static final double ATAQUE = 25;

	/**
	 * Crea a un lancero. <br>
	 * 
	 * @param posicion
	 *            Posición del lancero. <br>
	 */
	public Lancero(final int posicion) {
		super(posicion, VIDA, ATAQUE);
	}

	@Override
	public boolean distanciaValida(final int posicion) {
		if (Math.abs(super.getPosicion() - posicion) <= 3) {
			return true;
		}
		return false;
	}

	@Override
	public void atacar(final Unidad atacado) {
		if (distanciaValida(atacado.getPosicion())) {
			atacado.serAtacado(super.getDaño());
		}
	}
}