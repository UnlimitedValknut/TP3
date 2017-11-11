package inventario;

/**
 * Clase que administra la los atributos de un puñal.
 * <p>
 * La unidad recibe un aumento de fuerza pero se reduce su defensa. <br>
 */
public class Puñal extends Item {
	/**
	 * Modificador de fuerza. <br>
	 */
	private static final int MODIFICADOR_FUERZA = 3;
	/**
	 * Modificador de defensa. <br>
	 */
	private static final int MODIFICADOR_DEFENSA = 3;

	/**
	 * Le da un puñal a una unidad. <br>
	 *
	 * @param unidad
	 *            Unidad que recibe el puñal. <br>
	 */
	public Puñal() {
		super(MODIFICADOR_FUERZA, MODIFICADOR_DEFENSA);
	}
}
