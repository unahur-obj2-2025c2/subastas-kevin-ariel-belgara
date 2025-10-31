package ar.edu.unahur.obj2.observer;

public interface IObservado {
   void agregarObservador(IObservador observador);
   void eliminarObservador(IObservador observador);
   void notificar();
}
