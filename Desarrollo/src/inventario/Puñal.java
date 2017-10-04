package inventario;

import unidad.Unidad;
import unidad.UnidadDecorada;

/**
 * Clase que administra la los atributos de un puñal.
 * <p>
 * La unidad recibe un aumento de fuerza pero se reduce su defensa. <br>
 */
public class Puñal extends UnidadDecorada {
	/**
	 * Modificador de fuerza. <br>
	 */
	private static final int MODIFICADORFUERZA = 3;
	/**
	 * Modificador de defensa. <br>
	 */
	private static final int MODIFICADORDEFENSA = -3;

	@Override
	public double getDefensa() {
		return super.getDefensa() + MODIFICADORDEFENSA;
	}

	public double getDaño() {
		return super.getDaño() + MODIFICADORFUERZA;
	}
}