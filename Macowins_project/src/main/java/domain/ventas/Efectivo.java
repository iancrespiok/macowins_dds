package domain.ventas;

import java.util.List;

public class Efectivo implements MedioPago{
    public Efectivo() {
    }

    @Override
    public double facturacionEspecifica(List<Double> listaPrecios) {
        return listaPrecios.stream().mapToDouble(p->p).sum();
    }
}
