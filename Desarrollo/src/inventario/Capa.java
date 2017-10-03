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
	private static final double MULTIPLICADORENERGIA = 1;
	/**
	 * Multiplicador de ataque. <br>
	 */
	private static final double MULTIPLICADORATAQUE = -0.2;

	@Override
	public double getMultiplicadorAtaque() {
		return MULTIPLICADORATAQUE;
	}

	@Override
	public double getMultiplicadorEnergia() {
		return MULTIPLICADORENERGIA;
	}
}