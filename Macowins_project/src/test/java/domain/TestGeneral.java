package domain;

import domain.prendas.Prenda;
import domain.prendas.Promocion;
import domain.prendas.Tipo;
import org.junit.Assert;
import org.junit.Test;

public class TestGeneral {
    @Test
    public void precioPantalonDe100EnPromocionDe20Vale80(){
        Prenda unaPrenda = new Prenda(Tipo.PANTALONES, new Promocion(20),100);
        Assert.assertEquals(80,unaPrenda.precio().intValue());
    }

}
