package ar.edu.unahur.obj2.observer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductoSubastado implements IObservado {
    private Set<IObservador> subastadores = new HashSet<>();
    private List<Oferta> ofertasRecibidas = new ArrayList<>();
    @Override
    public void agregarObservador(IObservador observador) {
        subastadores.add(observador);
    }

    @Override
    public void eliminarObservador(IObservador observador) {
        subastadores.remove(observador);
    }
    @Override
    public void notificar() {
      subastadores.forEach(s-> s.actualizar(this.ultimaOfertaRealizada()));
        
    }
    public void agregarOferta(Oferta oferta) {
        ofertasRecibidas.add(oferta);
        notificar();
    }
    public void recibirOfertaDe(Subastador subastador){
        if(!subastadores.contains(subastador)){
            throw new SubastadorInvalidoException();
        }
        else{
            this.agregarOferta(subastador.nuevaOferta());
        }
    }
    public Oferta ultimaOfertaRealizada(){
        return ofertasRecibidas.get(ofertasRecibidas.size()-1);
    }
    public void reset(){
        this.ofertasRecibidas.clear();
        this.subastadores.clear();
    }

    public List<Oferta> getOfertasRecibidas() {
        return ofertasRecibidas;
    }


}
