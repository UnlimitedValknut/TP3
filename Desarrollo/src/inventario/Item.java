package inventario;

/**
 * Clase que administra los items. <br>
 */
public abstract class Item {
	/**
	 * Bonificación del item. <br>
	 */
	private double bonificacion;
	/**
	 * Penalización del item. <br>
	 */
	private double penalizacion;

	/**
	 * Crea un item. <br>
	 * 
	 * @param bonificacion
	 *            Bonificación del item. <br>
	 * @param penalizacion
	 *            Penalización del item. <br>
	 */
	public Item(final double bonificacion, final double penalizacion) {
		this.bonificacion = bonificacion;
		this.penalizacion = penalizacion;
	}

	/**
	 * Devuelve la bonificación del item. <br>
	 * 
	 * @return Bonificación del item. <br>
	 */
	public double getBonificacion() {
		return bonificacion;
	}

	/**
	 * Devuelve la penalización del item. <br>
	 * 
	 * @return Penalización del item. <br>
	 */
	public double getPenalizacion() {
		return penalizacion;
	}
}
