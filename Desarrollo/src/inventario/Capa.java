package inventario;

/**
 * Clase que administra la los atributos de una capa.
 * <p>
 * La unidad recibe un aumento de energía pero se ve afectado en el ataque. <br>
 */
public class Capa extends Item {

	/**
	 * Multiplicador de energía. <br>
	 */
	private static final double MULTIPLICADOR_ENERGIA = 2;
	/**
	 * Multiplicador de ataque. <br>
	 */
	private static final double MULTIPLICADOR_ATAQUE = 0.2;

	/**
	 * Crea una capa. <br>
	 */
	public Capa() {
		super(MULTIPLICADOR_ENERGIA, MULTIPLICADOR_ATAQUE);
	}
}