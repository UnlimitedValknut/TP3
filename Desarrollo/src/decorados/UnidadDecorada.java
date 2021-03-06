package decorados;

import unidad.Unidad;

/**
 * Clase que administra la unidad decorada. <br>
 */
public abstract class UnidadDecorada extends Unidad {
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
		return super.getSalud();
	}

	public double getDaño() {
		return super.getDaño();
	}

	public void cambiarPosicion(final int posicionNueva) {
		super.cambiarPosicion(posicionNueva);
	}
}
