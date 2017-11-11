package decorados;

import unidad.Unidad;

/**
 * Clase que administra la unidad decorada. <br>
 */
public abstract class UnidadDecorada extends Unidad {
	/**
	 * Unidad decorada. <br>
	 */
	private Unidad unidadDecorada;

	/**
	 * Crea una unidad decorada. <br>
	 * 
	 * @param unidad
	 *            Unidad. <br>
	 */
	public UnidadDecorada(final Unidad unidad) {
		super(unidad.getDaño(), unidad.getSalud(), unidad.getPosicion());
	}

	public double getSalud() {
		return unidadDecorada.getSalud();
	}

	public double getDaño() {
		return unidadDecorada.getDaño();
	}

	public void cambiarPosicion(final int posicionNueva) {
		this.unidadDecorada.cambiarPosicion(posicionNueva);
	}
}
