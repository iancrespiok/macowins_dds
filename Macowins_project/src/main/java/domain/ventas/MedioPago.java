package domain.ventas;

import java.util.ArrayList;
import java.util.List;

public interface MedioPago {
    abstract double facturacionEspecifica(List<Double> listaPrecios);
}
