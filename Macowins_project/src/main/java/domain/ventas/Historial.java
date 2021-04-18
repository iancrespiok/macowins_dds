package domain.ventas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Historial {
    List<Venta> listaVentas = new ArrayList<>();

    void agregarVenta(Venta venta){
        listaVentas.add(venta);
    }

    double gananciaDelDia(LocalDate fecha){
        return listaVentas.stream().
                mapToDouble(venta->venta.facturar()).
                sum();
    }
}


