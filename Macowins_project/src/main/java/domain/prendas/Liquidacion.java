package domain.prendas;

public class Liquidacion implements Estado{
    public Liquidacion() {
    }

    @Override
    public double precioPorEstado(double precioBase) {
        return (precioBase*0.5);
    }
}
