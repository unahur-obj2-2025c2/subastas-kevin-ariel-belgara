package ar.edu.unahur.obj2.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainTest {
    ProductoSubastado productoSubastado = new ProductoSubastado();
    Subastador subastador1 = new Subastador("gonzager");
    Subastador subastador2 = new Subastador("DIAZDAN");
    Subastador subastador3 = new Subastador("martomau");
    @BeforeEach
    void setUp() {
        productoSubastado.reset();
        subastador1.reset();
        subastador2.reset();
        subastador3.reset();
        productoSubastado.agregarObservador(subastador1);
        productoSubastado.agregarObservador(subastador3);
        productoSubastado.recibirOfertaDe(subastador1);
        productoSubastado.recibirOfertaDe(subastador3);
        productoSubastado.recibirOfertaDe(subastador1);

    }
    @Test
    void dado_Escenario_1_Se_Verifica_Que_Los_Subastadores_1_Y_3_Reciben_La_Ultima_Oferta_Realizada() {
        assert(subastador1.getUltimaOfertaRecibida().equals(productoSubastado.ultimaOfertaRealizada()));
        assert(subastador3.getUltimaOfertaRecibida().equals(productoSubastado.ultimaOfertaRealizada()));
    }
    @Test
    void dado_Escenario_1_Se_Verifica_Que_LaUltimaOfertaRegistradaPerteneceASubastador1() {
        assertEquals(subastador1, productoSubastado.ultimaOfertaRealizada().getSubastador());
    }
    @Test
    void dado_Escenario_1_Se_Verifica_Que_La_Ultima_Oferta_Registrada_Vale_30() {
        assertEquals(30, productoSubastado.ultimaOfertaRealizada().getValor());
    }
    @Test
    void dado_Escenario_1_Se_Verifica_Que_LaCantidadDeOfertasRegistradasEs3() {
        assertEquals(3, productoSubastado.getOfertasRecibidas().size());
    }
    @Test
    void dado_Escenario_1_Se_Verifica_Que_Subastador_2_No_Puede_Participar_De_La_Subasta() {
        boolean lanzaExcepcion = false;
        try {
            productoSubastado.recibirOfertaDe(subastador2);
        } catch (SubastadorInvalidoException e) {
            lanzaExcepcion = true;
        }
        assert(lanzaExcepcion);
    }
}
