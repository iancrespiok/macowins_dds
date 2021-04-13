class Prenda{
    string tipo;
    Estado estado;
    float precioBase;

    Prendas(string t, Estado e, float p){
        tipo = t;
        estado = e;
        precioBase = p;
    }

    float precio(){
        return estado.precioPorEstado(precioBase);
    }
}

interface Estado{
    float precioPorEstado(int pBase);
}

class Liquidacion implements Estado{
    public float precioPorEstado(int pBase){
        return (pBase*0.5)
    };
}

class Promocion implements Estado{
    float descuento;

    public float precioPorEstado(int pBase){
        return (pBase - descuento);
    }
}

class Nueva implements Estado{
    float precioPorEstado(int pBase){
        return pBase;
    }
}

class Venta{
    Date dia;
    MedioPago medioPago;
    boolean facturada;
    ArrayList<Prenda> listaPrendas = new ArrayList<>();

    void agregarPrenda(Prenda prenda){
        listaPrendas.add(prenda);
    }

    int cantidadPrendas(){
        return listaPrendas.size();
    }

    float facturar(){
        ArrayList<int> listaDePrecios = listaPrendas.stream().map(prenda->prenda.precio()).collect(Collectors.toList());
        facturada=true;
        return medioPago.facturacionEspecifica(listaDePrecios);
    }
}

interface MedioPago{
    float facturacionEspecifica(ArrayList<int> listaPrecios);
}

class Tarjeta implements MedioPago{
    int cuotas;
    float coeficienteFijo;

    public float facturacionEspecifica(ArrayList<int> listaPrecios) {
        float total = cuotas*coeficienteFijo;
        total += listaPrecios.stream().map(precio -> precio*0.01).sum();
        return total;
    }
}

class Efectivo implements MedioPago{
    public float facturacionEspecifica(ArrayList<int> listaPrecios) {
        return listaPrecios.sum()
    }
}

class Historial{
    ArrayList<Venta> listaVentas = new ArrayList<>();

    void agregarVenta(Venta venta){
        listaVentas.add(venta);
    }

    float gananciaDelDia(Date fecha){
        return listaVentas.stream().map(venta->venta.facturar()).sum();
    }
}