package unidad;

/**
 * Clase que define el comportamiento de las unidades. <br>
 */
public abstract class Unidad {
	/**
	 * Puntos de salud de la clase. <br>
	 */
	private double salud;
	/**
	 * Posición de la unidad. <br>
	 */
	private int posicion;
	/**
	 * Puntos de daños de la unidad. <br>
	 */
	private double daño;

	/**
	 * Crea una unidad. <br>
	 * 
	 * @param daño
	 *            Puntos de daño que realiza la unidad. <br>
	 * @param salud
	 *            Puntos de salud de la unidad. <br>
	 * @param posicion
	 *            Posición de la unidad. <br>
	 */
	public Unidad(final double daño, final double salud, final int posicion) {
		this.salud = salud;
		this.daño = daño;
		this.posicion = posicion;
	}

	/**
	 * Devuelve la posición de la unidad. <br>
	 *
	 * @return Posición de la unidad. <br>
	 */
	public int getPosicion() {
		return this.posicion;
	}

	/**
	 * Devuelve los puntos de salud de la unidad. <br>
	 *
	 * @return Puntos de salud de la unidad. <br>
	 */
	public double getSalud() {
		return this.salud;
	}

	/**
	 * Obtiene el daño que genera la unidad. <br>
	 *
	 * @return Daño realizado. <br>
	 */
	public double getDaño() {
		return this.daño;
	}

	/**
	 * Es atacado por otra unidad. <br>
	 *
	 * @param daño
	 *            Daño recibido. <br>
	 */
	public void serAtacado(final double daño) {
		this.salud -= daño;
		if (this.salud < 0) {
			this.salud = 0;
		}
	}

	/**
	 * Ataca a otra unidad. <br>
	 *
	 * @param unidad
	 *            Unidad atacada. <br>
	 * @return <b>true</b> si logró atacar.<br>
	 *         <b>false</b> si no logró atacar. <br>
	 */
	public boolean atacar(final Unidad unidad) {
		if (this.isVivo() && this.puedeAtacar(unidad)) {
			unidad.serAtacado(this.getDaño());
			return true;
		}
		return false;
	}

	/**
	 * Permite a la unidad cambiar su posición en el campo de batalla. <br>
	 *
	 * @param posicionNueva
	 *            Nueva posición de la unidad. <br>
	 */
	public void cambiarPosicion(final int posicionNueva) {
		this.posicion = posicionNueva;
	}

	/**
	 * Indica si la unidad se encuentra viva. <br>
	 *
	 * @return <b>true</b> si la unidad tiene puntos de vida.<br>
	 *         <b>false</b> si la unidad no tiene puntos de vida. <br>
	 */
	public boolean isVivo() {
		return this.salud > 0 ? true : false;
	}

	/**
	 * Indica si la unidad cumple con los requisitos para poder atacar a la otra
	 * unidad. <br>
	 * 
	 * @param unidad
	 *            Unidad atacada. <br>
	 * @return <b>true</b> si la unidad puede atacar.<br>
	 *         <b>false</b> si no cumple con los requisitos. <br>
	 */
	protected boolean puedeAtacar(final Unidad unidad){
		return true;
	}

	/**
	 * Indica si la unidad se encuentra a una distancia valida. <br>
	 * 
	 * @param posicion
	 *            Posición de la unidad. <br>
	 * @return <b>true</b> si se encuentra en una distancia valida.<br>
	 *         <b>false</b> de lo contrario. <br>
	 */
	protected boolean distanciaValida(final int posicion) {
		return true;
	}
}
