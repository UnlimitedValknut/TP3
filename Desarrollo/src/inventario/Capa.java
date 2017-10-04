package inventario;

import unidad.Unidad;
import unidad.UnidadDecorada;

/**
 * Clase que administra la los atributos de una capa.
 * <p>
 * La unidad recibe un aumento de energía pero se ve afectado en el ataque. <br>
 */
public class Capa extends UnidadDecorada {

	/**
	 * Multiplicador de energía. <br>
	 */
	private static final double MULTIPLICADORENERGIA = 2;
	/**
	 * Multiplicador de ataque. <br>
	 */
	private static final double MULTIPLICADORATAQUE = -0.2;

	@Override
	public double getDaño() {
		return super.getDaño() * MULTIPLICADORATAQUE;
	}

	@Override
	public double getEnergia() {
		return super.getEnergia() * MULTIPLICADORENERGIA;
	}
}