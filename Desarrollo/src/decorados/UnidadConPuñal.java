package decorados;

import inventario.Item;
import inventario.Puñal;
import unidad.Unidad;

/**
 * Clase que administra una unidad con puñal. <br>
 */
public class UnidadConPuñal extends UnidadDecorada {
	/**
	 * Puñal. <br>
	 */
	private Item puñal;

	/**
	 * Crea una unidad con puñal. <br>
	 * 
	 * @param unidad
	 *            Unidad. <br>
	 */
	public UnidadConPuñal(final Unidad unidad) {
		super(unidad);
		this.puñal = new Puñal();
	}

	@Override
	public void serAtacado(final double daño) {
		super.serAtacado(daño + this.puñal.getPenalizacion());
	}

	@Override
	public double getDaño() {
		return super.getDaño() + this.puñal.getBonificacion();
	}
}
