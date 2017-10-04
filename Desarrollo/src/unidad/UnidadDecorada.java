package unidad;

public class UnidadDecorada implements Unidad {
	protected Unidad unidadDecorada;

	public UnidadDecorada(final Unidad unidad) {

	}

	public double getDaño() {
		return this.unidadDecorada.getDaño();
	}

	public double getSalud() {
		return this.unidadDecorada.getSalud();
	}

	public int getPosicion() {
		return unidadDecorada.getPosicion();
	}

	@Override
	public double getDefensa() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void serAtacado(double daño) {
		// TODO Auto-generated method stub

	}

	@Override
	public double atacar(Unidad unidad) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void cambiarPosicion(int posicionNueva) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isVivo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double getEnergia() {
		// TODO Auto-generated method stub
		return 0;
	}

}