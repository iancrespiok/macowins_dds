package domain.ventas;

import java.util.List;

public class Tarjeta implements MedioPago {
    int cuotas;
    float coeficienteFijo;

    public Tarjeta(int cuotas, float coeficienteFijo) {
        this.cuotas = cuotas;
        this.coeficienteFijo = coeficienteFijo;
    }

    @Override
    public double facturacionEspecifica(List<Double> listaPrecios) {
        float total = cuotas*coeficienteFijo;
        total += listaPrecios.stream().mapToDouble(precio -> precio*0.01).sum();
        return total;
    }
}
