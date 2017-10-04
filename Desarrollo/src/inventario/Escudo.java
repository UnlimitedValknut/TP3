package inventario;

import unidad.Unidad;
import unidad.UnidadDecorada;

/**
 * Clase que administra la los atributos de un escudo.
 * <p>
 * La unidad con el escudo recibe un daño reducido con respecto al daño
 * original. <br>
 */
public class Escudo extends UnidadDecorada {
	/**
	 * Multiplicador de defensa.
	 */
	private static final double MULTIPLICADORDEFENSA = 0.4;

	public Escudo(Unidad unidad) {
		super(unidad);
	}

	@Override
	public double getDefensa() {
		return super.getDefensa() * MULTIPLICADORDEFENSA;
	}
}