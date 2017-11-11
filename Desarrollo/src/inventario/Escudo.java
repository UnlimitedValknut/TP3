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
	private static final double MULTIPLICADOR_DEFENSA = 0.4;

	/**
	 * Crea un escudo. <br>
	 */
	public Escudo() {
		super(MULTIPLICADOR_DEFENSA, 0);
	}
}