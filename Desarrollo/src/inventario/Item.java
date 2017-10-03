package inventario;

/**
 * Clase que administra los distintos modificadores de un item. <br>
 */
public abstract class Item {
	/**
	 * Obtiene el multiplicador de ataque del item. <br>
	 * 
	 * @return Multiplicador de ataque. <br>
	 */
	public double getMultiplicadorAtaque() {
		return 0;
	}

	/**
	 * Obtiene el modificador de ataque del item. <br>
	 * 
	 * @return Modificador de ataque. <br>
	 */
	public int getSumaAtaque() {
		return 0;
	}

	/**
	 * Obtiene el multiplicador de defensa del item. <br>
	 * 
	 * @return Multiplicador de defensa. <br>
	 */
	public double getMultiplicadorDefensa() {
		return 0;
	}

	/**
	 * Obtiene el modificador de defensa del item. <br>
	 * 
	 * @return Modificador de defensa. <br>
	 */
	public int getSumaDefensa() {
		return 0;
	}

	/**
	 * Obtiene el multiplicador de energía del item. <br>
	 * 
	 * @return Multiplicador de energía. <br>
	 */
	public double getMultiplicadorEnergia() {
		return 0;
	}
}