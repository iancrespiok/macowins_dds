package domain.ventas;
import domain.prendas.Prenda;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Venta {
    LocalDate dia;
    MedioPago medioPago;
    boolean facturada;
    List<Prenda> listaPrendas = new ArrayList<>();

    public Venta(LocalDate dia, MedioPago medioPago, List<Prenda> listaPrendas) {
        this.dia = dia;
        this.medioPago = medioPago;
        this.listaPrendas = listaPrendas;
    }

    void agregarPrendas(Prenda ... prendas){
        Collections.addAll(this.listaPrendas,prendas);
    }

    int cantidadPrendas(){
        return listaPrendas.size();
    }

    double facturar(){
        List<Double> listaDePrecios = listaPrendas.stream()
                .map(prenda->prenda.precio())
                .collect(Collectors.toList());
        facturada=true;
        return medioPago.facturacionEspecifica(listaDePrecios);
    }
}
