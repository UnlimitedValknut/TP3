package unidad;

public abstract class UnidadDecorada extends Unidad {
	protected Unidad unidadDecorada;

	public UnidadDecorada(final Unidad unidad) {
		super(unidad);
	}

	@Override
	public double getDaño() {
		return this.unidadDecorada.getDaño();
	}

	@Override
	public double getSalud() {
		return this.unidadDecorada.getSalud();
	}

	public double getDefensa() {
		return 0;
	}
}