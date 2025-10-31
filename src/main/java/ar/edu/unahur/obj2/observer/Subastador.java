package ar.edu.unahur.obj2.observer;

public class Subastador implements IObservador {
  private String nombre;
  private Oferta ultimaOfertaRecibida;

  public Subastador(String nombre) {
    this.nombre = nombre;
  }
  public String getNombre() {
       return nombre;
    }
  public Oferta nuevaOferta(){
    return new Oferta(this,ultimaOfertaRecibida.getValor() + 10);
  }
  @Override
  public void actualizar(Oferta oferta) {
    this.ultimaOfertaRecibida = oferta;
    
  }
  public void reset(){
    this.ultimaOfertaRecibida = new Oferta(this,0);
  }
  public Oferta getUltimaOfertaRecibida() {
    return ultimaOfertaRecibida;
  }

}
