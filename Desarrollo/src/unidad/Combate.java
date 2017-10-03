package unidad;

/**
 * Interfaz que se encarga del manejo del combate. <br>
 */
public interface Combate {
	/**
	 * Ataca a una unidad. <br>
	 * 
	 * @param atacado
	 *            Unidad atacada. <br>
	 */
	public void atacar(final Unidad atacado);

	/**
	 * Una unidad recibe daño. <br>
	 * 
	 * @param daño
	 *            Daño recibido. <br>
	 */
	public void serAtacado(final double daño);

	/**
	 * Indica si la distancia para atacar a la unidad es válida. <br>
	 * 
	 * @param posicion
	 *            Posición de la unidad enemiga. <br>
	 * @return true si es válida, false de lo contrario. <br>
	 */
	public boolean distanciaValida(final int posicion);
}
