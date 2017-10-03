package inventario;

/**
 * Clase que administra la los atributos de un escudo.
 * <p>
 * La unidad con el escudo recibe un daño reducido con respecto al daño
 * original. <br>
 */
public class Escudo extends Item {
	/**
	 * Multiplicador de defensa.
	 */
	private static final double MULTIPLICADORDEFENSA = 0.4;

	@Override
	public double getMultiplicadorDefensa() {
		return MULTIPLICADORDEFENSA;
	}
}