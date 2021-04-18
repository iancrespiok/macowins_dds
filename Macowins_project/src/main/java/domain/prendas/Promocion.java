package domain.prendas;

public class Promocion implements Estado{
    double descuento;

    public Promocion(double descuento) {
        this.descuento = descuento;
    }

    public double precioPorEstado(double precioBase){
        return (precioBase - descuento);
    }
}
