package unidad;

/**
 * Interfaz que define el comportamiento de las unidades. <br>
 */
public interface Unidad {
	/**
	 * Devuelve la posición de la unidad. <br>
	 * 
	 * @return Posición de la unidad. <br>
	 */
	public int getPosicion();

	/**
	 * Devuelve los puntos de salud de la unidad. <br>
	 * 
	 * @return Puntos de salud de la unidad. <br>
	 */
	public double getSalud();

	/**
	 * Obtiene el daño que genera la unidad.
	 * <p>
	 * Tiene en cuenta los items equipados. <br>
	 * 
	 * @return Daño realizado. <br>
	 */
	public double getDaño();

	/**
	 * Devuelve la defensa de la unidad. <br>
	 * 
	 * @return Defensa de la unidad. <br>
	 */
	public double getDefensa();

	/**
	 * Devuelve la energía de la unidad. <br>
	 * 
	 * @return Energía. <br>
	 */
	public double getEnergia();

	/**
	 * Es atacado por otra unidad. <br>
	 * 
	 * @param daño
	 *            Daño recibido. <br>
	 */
	public void serAtacado(final double daño);

	/**
	 * Ataca a otra unidad. <br>
	 * 
	 * @param unidad
	 *            Unidad atacada. <br>
	 * @return Daño realizado. <br>
	 */
	public double atacar(final Unidad unidad);

	/**
	 * Permite a la unidad cambiar su posición en el campo de batalla. <br>
	 * 
	 * @param posicionNueva
	 *            Nueva posición de la unidad. <br>
	 */
	public void cambiarPosicion(final int posicionNueva);

	/**
	 * Indica si la unidad se encuentra viva. <br>
	 * 
	 * @return <b>true</b> si la unidad tiene puntos de vida.<br>
	 *         <b>false</b> si la unidad no tiene puntos de vida. <br>
	 */
	public boolean isVivo();
}