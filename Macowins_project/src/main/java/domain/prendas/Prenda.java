package domain.prendas;

public class Prenda {
    private Tipo tipo;
    private Estado estado;
    private Double precioBase;

    public Prenda(Tipo t, Estado e, double p){
        tipo = t;
        estado = e;
        precioBase = p;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public Double precio(){
        return estado.precioPorEstado(this.precioBase);
    }
}
