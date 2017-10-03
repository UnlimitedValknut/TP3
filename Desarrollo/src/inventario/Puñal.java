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
	private static final int MODIFICADORFUERZA = 3;
	/**
	 * Modificador de defensa. <br>
	 */
	private static final int MODIFICADORDEFENSA = -3;

	@Override
	public int getSumaDefensa() {
		return MODIFICADORDEFENSA;
	}

	@Override
	public int getSumaAtaque() {
		return MODIFICADORFUERZA;
	}
}