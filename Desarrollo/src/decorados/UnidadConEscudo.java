package decorados;

import inventario.Escudo;
import inventario.Item;
import unidad.Unidad;

/**
 * Clase que administra una unidad con escudo. <br>
 */
public class UnidadConEscudo extends UnidadDecorada {
	/**
	 * Escudo. <br>
	 */
	private Item escudo;

	/**
	 * Crea una unidad con escudo. <br>
	 * 
	 * @param unidad
	 *            Unidad. <br>
	 */
	public UnidadConEscudo(final Unidad unidad) {
		super(unidad);
		this.escudo = new Escudo();
	}

	@Override
	public void serAtacado(final double daño) {
		super.serAtacado(daño * this.escudo.getBonificacion());
	}
}
