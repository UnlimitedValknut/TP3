package unidad;

/**
 * Clase que administra la unidad del arquero.
 * <p>
 * El arquero utiliza flechas para atacar. Una vez terminada sus flechas, debe
 * recargar su carcaj con un paquete de flechas. <br>
 */
public class Arquero implements Unidad {
	/**
	 * Puntos de vida del arquero. <br>
	 */
	private static final double VIDA = 50;
	/**
	 * Ataque del arquero. <br>
	 */
	private static final double ATAQUE = 5;
	/**
	 * Cantidad de flechas con las que empiza el arquero. <br>
	 */
	private static final int FLECHASINICIALES = 20;
	/**
	 * Cantidad de flechas que recarga el arquero por vez. <br>
	 */
	private static final int RECARGAFLECHAS = 6;
	/**
	 * Posicion del arquero. <br>
	 */
	private int posicion;
	private double salud;
	private double ataque;
	/**
	 * Cantidad de flechas que dispone el arquero en su carcaj. <br>
	 */
	private int flechasDisponibles;

	/**
	 * Crea un arquero. <br>
	 * 
	 * @param posicion
	 *            Posición del arquero. <br>
	 */
	public Arquero(final int posicion) {
		this.salud = VIDA;
		this.ataque = ATAQUE;
		this.posicion = posicion;
		this.flechasDisponibles = FLECHASINICIALES;
	}

	/**
	 * Recarga 6 flechas al arquero.<br>
	 */
	public void recargarFlechas() {
		this.flechasDisponibles += RECARGAFLECHAS;
	}

	@Override
	public void atacar(final Unidad atacado) {
		if (this.flechasDisponibles > 0 && distanciaValida(atacado.getPosicion()) && atacado.isVivo()) {
			atacado.serAtacado(super.getDaño());
			this.flechasDisponibles--;
		}
	}

	@Override
	public boolean distanciaValida(final int posicion) {
		if (Math.abs(super.getPosicion() - posicion) <= 5 && Math.abs(super.getPosicion() - posicion) >= 2) {
			return true;
		}
		return false;
	}

	@Override
	public int getPosicion() {
		return this.posicion;
	}

	@Override
	public double getSalud() {
		return this.salud;
	}

	@Override
	public double getDaño() {
		return this.ataque;
	}

	@Override
	public double getDefensa() {
		return 0;
	}

	@Override
	public void serAtacado(double daño) {

	}

	@Override
	public void cambiarPosicion(int posicionNueva) {
		this.posicion = posicionNueva;
	}

	@Override
	public boolean isVivo() {
		return (this.salud != 0 ? true : false);
	}
}