package decorados;

import inventario.Capa;
import inventario.Item;
import unidad.Unidad;

/**
 * Clase que administra una unidad con capa. <br>
 */
public class UnidadConCapa extends UnidadDecorada {
	/**
	 * Capa. <br>
	 */
	private Item capa;

	/**
	 * Crea una unidad con capa. <br>
	 * 
	 * @param unidad
	 *            Unidad. <br>
	 */
	public UnidadConCapa(final Unidad unidad) {
		super(unidad);
		this.capa = new Capa();
	}

	@Override
	public double getDaño() {
		return super.getDaño() - this.capa.getPenalizacion();
	}
}
